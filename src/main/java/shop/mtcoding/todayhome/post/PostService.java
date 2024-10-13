package shop.mtcoding.todayhome.post;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public PostResponse.ListDTO 공고리스트(Integer categoryId, int page) {

        Pageable pageable = PageRequest.of(page -1, 3);
        List<Post> bestSellingPosts = postRepository.findAllPostsOrderBySales(pageable);
        List<Post>  recentPosts = postRepository.findTop5ByOrderByCreatedAtDesc();
        // 가져온 데이터를 출력해서 확인
        System.out.println("Recent Posts Size: " + recentPosts.size());
        System.out.println("Best Selling Posts Size: " + bestSellingPosts.size());
        return new PostResponse.ListDTO(recentPosts, bestSellingPosts);
    }

    public void 상세보기(Integer postId, Integer userId) {
            

    }
}
