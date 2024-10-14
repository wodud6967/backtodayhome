package shop.mtcoding.todayhome.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi401;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;
import shop.mtcoding.todayhome.core.util.JwtUtil;

import java.util.Optional;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final  UserRepository userRepository;

    public void 나의리뷰조회(User sessionUser) {

    }

    public String 로그인(UserRequest.LoginDTO loginDTO) {
        User userPS = userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword())
                .orElseThrow(() -> new ExceptionApi401("아이뒤또는 이메일이 틀렸습니다."));

        String accessToken = JwtUtil.create(userPS);
        return accessToken;

    }
}
