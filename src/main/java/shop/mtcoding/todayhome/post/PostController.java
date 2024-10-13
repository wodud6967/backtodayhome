package shop.mtcoding.todayhome.post;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import shop.mtcoding.todayhome.core.util.Resp;
import shop.mtcoding.todayhome.user.User;


@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private HttpSession session;



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
    @GetMapping("/api/posts/{postId}")
    public ResponseEntity<?> postDetail(
            @PathVariable("postId") Integer postId,
            HttpServletRequest request
    ){
        User sessionUser =  (User)session.getAttribute("sessionUser");
        Integer userId = sessionUser.getId();
        System.out.println(userId);
        postService.상세보기(postId,userId);
        return ResponseEntity.ok().body(null);
    }


}
