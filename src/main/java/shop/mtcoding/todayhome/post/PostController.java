package shop.mtcoding.todayhome.post;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import shop.mtcoding.todayhome.core.util.Resp;


@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;



    @GetMapping("/api/category/{categoryId}/posts")
    public ResponseEntity<?> listPostsByCategory(
            @PathVariable("categoryId") Integer categoryId,
            @RequestParam(defaultValue = "1") int page,
            HttpServletRequest request
    ){
        PostResponse.ListDTO model = postService.공고리스트(categoryId,page);

        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + request.getHeader("Authorization")) // 토큰을 그대로 반환
                .body(Resp.ok(model));


    }


}
