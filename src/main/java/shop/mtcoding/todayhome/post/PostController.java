package shop.mtcoding.todayhome.post;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostRepository postRepository;


    @GetMapping("/api/categorys")
    public ResponseEntity<?> category(HttpServletRequest request){





        return ResponseEntity.ok().body(null);
    }

}
