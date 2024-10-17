package shop.mtcoding.todayhome.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import shop.mtcoding.todayhome.core.util.Resp;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/api/user/feed")
    public ResponseEntity<?> getUserFeed() {
        User sessionUser = (User) session.getAttribute("sessionUser");

        // 만약 모든 유저의 피드를 조회하는 기능이라면, sessionUser를 파라미터로 넘기지 않고 그냥 호출
        List<UserResponse.UserDTO> userDTOList = userService.모든유저피드조회();

        return ResponseEntity.ok(userDTOList);
    }

    @GetMapping("/api/user/myorder")
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
        UserResponse.LoginDTO responseDTO = userService.로그인(loginDTO);

        return ResponseEntity.ok()
                .header("Authorization","Bearer " + responseDTO.accessToken())
                .body(Resp.ok(responseDTO));
    }
}
