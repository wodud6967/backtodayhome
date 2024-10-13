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
        List<Post> bestSellingPosts = postRepository.findAllPostsOrderBySales(pageable);
        List<Post> recentPosts = postRepository.findTop5ByOrderByCreatedAtDesc();
        // 가져온 데이터를 출력해서 확인
        System.out.println("Recent Posts Size: " + recentPosts.size());
        System.out.println("Best Selling Posts Size: " + bestSellingPosts.size());
        return new PostResponse.ListDTO(recentPosts, bestSellingPosts);
    }


    public PostDetailResponse.PostDTO 상세보기(Integer postId) {
        // 게시물 조회
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시물이 존재하지 않습니다."));

        // DTO 초기화
        PostDetailResponse.PostDTO postDTO = new PostDetailResponse.PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getPrice(),
                post.getMainPhoto()
        );

        // 옵션 그룹 초기화
        List<PostDetailResponse.OptionGroupDTO> optionGroups = new ArrayList<>();

        // 사이즈 옵션 그룹 생성
        PostDetailResponse.OptionGroupDTO sizeGroup = new PostDetailResponse.OptionGroupDTO();
        sizeGroup.setOptionName("옵션1"); // 사이즈
        List<PostDetailResponse.OptionValueDTO> sizeValues = new ArrayList<>();

        // 각 상품의 옵션 확인
        for (Product product : post.getProducts()) {
            for (Option option : product.getOptions()) {
                // 사이즈 옵션 추가
                if ("사이즈".equals(option.getOptionType().getType())) {
                    sizeValues.add(new PostDetailResponse.OptionValueDTO(
                            option.getId(),
                            option.getContent(),
                            "가격 범위 예시", // 가격 범위는 필요에 따라 설정
                            0, // 가격은 0으로 설정
                            postId
                    ));
                }
            }
        }
        sizeGroup.setValues(sizeValues);
        optionGroups.add(sizeGroup);

        // 색상 옵션 그룹 생성
        PostDetailResponse.OptionGroupDTO colorGroup = new PostDetailResponse.OptionGroupDTO();
        colorGroup.setOptionName("옵션2"); // 색상
        List<PostDetailResponse.OptionValueDTO> colorValues = new ArrayList<>();

        for (Product product : post.getProducts()) {
            for (Option option : product.getOptions()) {
                // 색상 옵션 추가
                if ("색상".equals(option.getOptionType().getType())) {
                    colorValues.add(new PostDetailResponse.OptionValueDTO(
                            option.getId(),
                            option.getContent(),
                            null, // 가격 범위는 없으므로 null
                            0, // 가격도 0으로 설정
                            postId
                    ));
                }
            }
        }
        colorGroup.setValues(colorValues);
        optionGroups.add(colorGroup);

        // 최종 DTO에 옵션 그룹 추가
        postDTO.setOptionGroups(optionGroups);

        return postDTO;
    }
}