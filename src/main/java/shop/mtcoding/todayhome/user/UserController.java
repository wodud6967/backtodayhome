package shop.mtcoding.todayhome.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import shop.mtcoding.todayhome.core.util.Resp;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/api/user/myorder") // 작업중
    public ResponseEntity<?> getMyOrder() {
        User sessionUser = (User) session.getAttribute("sessionUser");
        UserResponse.UserOrderDTO myOrderDTO = userService.나의주문조회(sessionUser);
        return ResponseEntity.ok(Resp.ok(myOrderDTO));
    }

    @GetMapping("/api/user/myreview")
    public ResponseEntity<?> getMyReview() {
        User sessionUser = (User) session.getAttribute("sessionUser");
        UserResponse.UserReviewDTO myReviewDTO = userService.나의리뷰조회(sessionUser);
        return ResponseEntity.ok(Resp.ok(myReviewDTO));
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserRequest.LoginDTO loginDTO){
        String accessToken = userService.로그인(loginDTO);

        return ResponseEntity.ok()
                .header("Authorization","Bearer " + accessToken)
                .body(Resp.ok(null));
    }
}
