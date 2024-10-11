package shop.mtcoding.todayhome.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import shop.mtcoding.todayhome.core.util.Resp;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserRequest.LoginDTO loginDTO){
        String accessToken = userService.로그인(loginDTO);

        return ResponseEntity.ok()
                .header("Authorization","Bearer " + accessToken)
                .body(Resp.ok(null));
    }
}
