package shop.mtcoding.todayhome.review;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import shop.mtcoding.todayhome.core.util.Resp;
import shop.mtcoding.todayhome.user.User;

@RequiredArgsConstructor
@Controller
public class ReviewController {

    private final ReviewService reviewService;
    private final HttpSession session;

    @PostMapping("/api/review")
    public ResponseEntity<?> save(@RequestBody ReviewRequest.SaveDTO saveDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
//        System.out.println(sessionUser);
//        System.out.println(sessionUser.getId());
        ReviewResponse.DTO reviewDTO = reviewService.리뷰쓰기(saveDTO, sessionUser);
        return ResponseEntity.ok(Resp.ok(reviewDTO));
    }

}
