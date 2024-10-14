package shop.mtcoding.todayhome.post;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.inventory.Inventory;
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

        // 페치 조인으로 리뷰 포함된 포스트들 가져오기
        List<Post> bestSellingPosts = postRepository.findAllPostsOrderBySales();
        List<Post> recentPosts = postRepository.findAllPostsOrderByCreatedAtDesc();

        System.out.println("Recent Posts Size: " + recentPosts.size());
        System.out.println("Best Selling Posts Size: " + bestSellingPosts.size());

        return new PostResponse.ListDTO(recentPosts, bestSellingPosts);
    }


    public PostDetailResponse.PostDTO 상세보기(Integer postId) {
        // 1. Post 데이터를 가져옴
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));

        // 2. Inventory 테이블을 통해 모든 상품, 옵션1, 옵션2 정보를 조회
        List<Inventory> inventories = inventoryRepository.findByProductPostId(postId);

        // 옵션 그룹과 추가 상품을 나눌 맵과 리스트 준비
        Map<String, List<PostDetailResponse.OptionValueDTO>> optionGroups = new HashMap<>();
        List<PostDetailResponse.OptionValueDTO> additionalProducts = new ArrayList<>();
        Map<String, List<Integer>> priceRanges = new HashMap<>(); // 각 부모 옵션에 대한 가격 범위 계산을 위한 맵

        // 3. Inventory 기반으로 부모/자식 옵션과 추가 상품 처리
        for (Inventory inventory : inventories) {
            Product product = inventory.getProduct();
            Option option1 = inventory.getOption1(); // 첫 번째 옵션 (예: 사이즈)
            Option option2 = inventory.getOption2(); // 두 번째 옵션 (예: 색상)

            // 옵션의 총 가격 계산 (상품 기본 가격 + 옵션 가격들)
            int totalPrice = product.getPrice();
            if (option1 != null) {
                totalPrice += option1.getPrice();
            }
            if (option2 != null) {
                totalPrice += option2.getPrice();
            }

            // 옵션이 없는 상품은 추가 상품 리스트에 추가
            if (option1 == null && option2 == null) {
                additionalProducts.add(new PostDetailResponse.OptionValueDTO(

                        product.getName(), // 상품 이름
                        totalPrice, // 상품 가격
                        post.getId(), // Post ID 전달
                        inventory.getId() // Inventory ID 전달
                ));
                continue;
            }

            // 부모 옵션 (option1) 그룹화
            String option1Key = option1 != null ? option1.getContent() : "기타 옵션";
            PostDetailResponse.OptionValueDTO optionDTO = new PostDetailResponse.OptionValueDTO(

                    option2 != null ? option2.getContent() : option1.getContent(), // option2가 있으면 사용, 없으면 option1 사용
                    totalPrice, // 상품 가격
                    post.getId(), // Post ID 전달
                    inventory.getId() // Inventory ID 전달
            );

            // 가격 범위 계산을 위한 가격 저장
            priceRanges.computeIfAbsent(option1Key, k -> new ArrayList<>()).add(totalPrice);

            // 옵션 그룹에 추가 (부모 옵션 이름을 기준으로 그룹화)
            optionGroups.computeIfAbsent(option1Key, k -> new ArrayList<>()).add(optionDTO);
        }

        // 4. 부모 옵션 그룹 및 추가 상품 그룹 생성 (가격 범위 포함)
        List<PostDetailResponse.OptionGroupDTO> optionGroupDTOs = new ArrayList<>();
        for (Map.Entry<String, List<PostDetailResponse.OptionValueDTO>> entry : optionGroups.entrySet()) {
            String optionName = entry.getKey();
            List<PostDetailResponse.OptionValueDTO> optionValues = entry.getValue();

            // 가격 범위 계산 (최소값과 최대값)
            List<Integer> prices = priceRanges.get(optionName);
            String priceRange = "";
            if (prices != null && !prices.isEmpty()) {
                int minPrice = Collections.min(prices);
                int maxPrice = Collections.max(prices);
                priceRange = String.format("%,d ~ %,d", minPrice, maxPrice);
            }

            // 부모 옵션 그룹 DTO 생성 (가격 범위 포함)
            optionGroupDTOs.add(new PostDetailResponse.OptionGroupDTO(optionName, priceRange, optionValues));
        }

        // 추가 상품이 있으면 추가 상품 그룹을 생성
        if (!additionalProducts.isEmpty()) {
            optionGroupDTOs.add(new PostDetailResponse.OptionGroupDTO("추가상품(선택)", null, additionalProducts));
        }

        // 5. 리뷰 데이터 처리
        List<PostDetailResponse.ReviewDTO> reviewDTOList = new ArrayList<>();
        for (Review review : post.getReviews()) {
            PostDetailResponse.ReviewDTO reviewDTO = new PostDetailResponse.ReviewDTO(review);
            reviewDTOList.add(reviewDTO);
        }

        // 6. 최종 PostDTO에 옵션 그룹과 리뷰 추가
        PostDetailResponse.PostDTO postDTO = new PostDetailResponse.PostDTO(post);
        postDTO.setOptionGroups(optionGroupDTOs);
        postDTO.setReviews(reviewDTOList); // 리뷰 추가

        return postDTO;
    }
}