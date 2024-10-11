package shop.mtcoding.todayhome.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@DataJpaTest
public class ProductRepository {

    @Autowired
    private PostRepository postRepository;


    @Test
    public void testBestSellingPosts() {
        int page = 1;  // 첫 번째 페이지
        Pageable pageable = PageRequest.of(page -1, 3);
        List<Post> posts = postRepository.findAllPostsOrderBySales(pageable);


        for (Post post : posts) {
            System.out.println(post.getTitle());
        }


    }

    @Test
    public void createdList(){
        List<Post> posts = postRepository.findTop5ByOrderByCreatedAtDesc();

        for (Post post : posts) {
            System.out.println(post.getTitle());
        }
    }
}
