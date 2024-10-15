package shop.mtcoding.todayhome.post;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.todayhome.core.util.Resp;
import shop.mtcoding.todayhome.user.User;


@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final HttpSession session;


    @PostMapping("/api/post")
    public ResponseEntity<?> save(@RequestBody PostRequest.SaveDTO postRequest,HttpServletRequest request) {
        User user =  (User) session.getAttribute("sessionUser");

        System.out.println("전달된 subCategoryId: " + postRequest.getSubCategoryId());

        System.out.println("컨트롤러로 왔나?");
        PostSaveResponse.DTO model = postService.공고쓰기(postRequest, user);


        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + request.getHeader("Authorization")) // 토큰을 그대로 반환
                .body(Resp.ok(model));

    }


    @GetMapping("/api/category/{categoryId}/posts")
    public ResponseEntity<?> listPostsByCategory(
            @PathVariable("categoryId") Integer categoryId,
            @RequestParam(defaultValue = "1") int page,
            HttpServletRequest request
    ){
        User user =  (User) session.getAttribute("sessionUser");
        System.out.println("accesstoken :" +user.getId());

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

        User user =  (User) session.getAttribute("sessionUser");

        System.out.println("accesstoken :" +user.getId());

        PostDetailResponse.PostDTO  model = postService.상세보기(postId);

        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + request.getHeader("Authorization")) // 토큰을 그대로 반환
                .body(Resp.ok(model));
    }


}
