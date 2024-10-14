package shop.mtcoding.todayhome.post;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.inventory.InventoryRepository;
import shop.mtcoding.todayhome.option.Option;
import shop.mtcoding.todayhome.option.OptionRepository;
import shop.mtcoding.todayhome.product.Product;
import shop.mtcoding.todayhome.product.ProductRepository;
import shop.mtcoding.todayhome.productoption.ProductOption;
import shop.mtcoding.todayhome.review.Review;

import java.util.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final ProductRepository productRepository;
    private final InventoryRepository inventoryRepository;
    private final OptionRepository optionRepository;


    public PostResponse.ListDTO 공고리스트(Integer categoryId, int page) {

        Pageable pageable = PageRequest.of(page - 1, 3);
        List<Post> bestSellingPosts = postRepository.findAllPostsOrderBySales();
        List<Post> recentPosts = postRepository.findAllPostsOrderByCreatedAtDesc();
        // 가져온 데이터를 출력해서 확인
        System.out.println("Recent Posts Size: " + recentPosts.size());
        System.out.println("Best Selling Posts Size: " + bestSellingPosts.size());
        return new PostResponse.ListDTO(recentPosts, bestSellingPosts);
    }


    public PostDetailResponse.PostDTO 상세보기(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));

        // 1. 부모 옵션 처리 (우선순위 1번)
        List<Option> parentOptions = postRepository.findFirstPriorityOptionsByPriority();
        String parentOptionName = parentOptions.get(0).getOptionType().getType(); // 첫 번째 옵션의 OptionType 이름으로 설정

        List<PostDetailResponse.OptionValueDTO> parentOptionValues = new ArrayList<>();
        Map<Integer, String> parentOptionMap = new HashMap<>(); // 부모 옵션 ID와 이름을 매핑
        Map<Integer, List<Integer>> priceMapByParent = new HashMap<>(); // 부모 옵션 ID와 자식 옵션 가격 리스트 매핑
        int idCounter = 1;

        for (Option option : parentOptions) {
            parentOptionMap.put(idCounter, option.getContent()); // 옵션 ID와 이름을 매핑
            priceMapByParent.put(idCounter, new ArrayList<>());  // 각 부모 옵션에 대한 자식 가격 리스트 초기화
            idCounter++;
        }

        // 2. 자식 옵션 처리 (우선순위 2번)
        List<ProductOption> childOptions = postRepository.findChildOptionsByPriority();
        Map<Integer, List<PostDetailResponse.OptionValueDTO>> childGroupedByParent = new HashMap<>(); // 부모 옵션 ID로 자식 옵션을 그룹화

        for (ProductOption productOption : childOptions) {
            Integer productId = productOption.getProduct().getId();
            String childOptionValue = productOption.getOption().getContent();
            Integer price = productOption.getProduct().getPrice();

            // 부모 옵션 ID를 찾아 자식 옵션을 매핑
            Integer parentId = parentOptionMap.entrySet().stream()
                    .filter(entry -> productOption.getProduct().getName().contains(entry.getValue())) // 부모 옵션 이름을 포함하는지 확인
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(null);

            if (parentId != null) {
                PostDetailResponse.OptionValueDTO childOptionDTO = new PostDetailResponse.OptionValueDTO(productId, childOptionValue, "", price, postId);
                childGroupedByParent.computeIfAbsent(parentId, k -> new ArrayList<>()).add(childOptionDTO);
                priceMapByParent.get(parentId).add(price); // 부모 옵션에 해당하는 자식 가격 추가
            }
        }

        // 부모 옵션 처리 (priceRange 계산)
        idCounter = 1;
        for (Option option : parentOptions) {
            List<Integer> prices = priceMapByParent.get(idCounter);
            if (!prices.isEmpty()) {
                int minPrice = Collections.min(prices);
                int maxPrice = Collections.max(prices);
                String priceRange = String.format("%,d ~ %,d", minPrice, maxPrice);
                PostDetailResponse.OptionValueDTO valueDTO = new PostDetailResponse.OptionValueDTO(idCounter, option.getContent(), priceRange, 1, postId);
                parentOptionValues.add(valueDTO);
            }
            idCounter++;
        }

        // 부모 옵션 그룹 생성
        PostDetailResponse.OptionGroupDTO parentOptionGroup = new PostDetailResponse.OptionGroupDTO(parentOptionName, parentOptionValues);

        // 자식 옵션 그룹 생성 (옵션 유형 이름을 동적으로 설정)
        String childOptionName = childOptions.get(0).getOption().getOptionType().getType(); // 우선순위 2번 옵션의 OptionType 이름 가져오기
        PostDetailResponse.OptionGroupDTO childOptionGroup = new PostDetailResponse.OptionGroupDTO(childOptionName, childGroupedByParent);

        // 3. 추가 상품 처리
        List<Product> additionalProducts = postRepository.findAdditionalProducts();
        List<PostDetailResponse.OptionValueDTO> additionalValues = new ArrayList<>();

        for (Product product : additionalProducts) {
            PostDetailResponse.OptionValueDTO valueDTO = new PostDetailResponse.OptionValueDTO(product.getId(), product.getName(), "", product.getPrice(), postId);
            additionalValues.add(valueDTO);
        }

        PostDetailResponse.OptionGroupDTO additionalGroup = new PostDetailResponse.OptionGroupDTO("추가상품(선택)", additionalValues);

        // 4. 리뷰 데이터 처리
        List<PostDetailResponse.ReviewDTO> reviewDTOList = new ArrayList<>();
        for (Review review : post.getReviews()) {
            PostDetailResponse.ReviewDTO reviewDTO = new PostDetailResponse.ReviewDTO(review);
            reviewDTOList.add(reviewDTO);
        }

        // PostDTO에 옵션 그룹 추가
        PostDetailResponse.PostDTO postDTO = new PostDetailResponse.PostDTO(post);
        postDTO.getOptionGroups().add(parentOptionGroup);
        postDTO.getOptionGroups().add(childOptionGroup);
        postDTO.getOptionGroups().add(additionalGroup);
        postDTO.setReviews(reviewDTOList); // 리뷰 추가

        return postDTO;
    }
}