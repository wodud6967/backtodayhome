package shop.mtcoding.todayhome.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.todayhome.core.util.JwtUtil;

import java.util.Optional;

@DataJpaTest
public class UserRepositort {

    @Autowired UserRepository userRepository;


    @Test
    public void 로그인() {
        String username = "ssar";
        String password = "1234";

       Optional<User> user = userRepository.findByUsernameAndPassword(username, password);

        System.out.println(user.get().getEmail());

        String accessToken =  JwtUtil.create(user.get());

        System.out.println(accessToken);
    }

}
