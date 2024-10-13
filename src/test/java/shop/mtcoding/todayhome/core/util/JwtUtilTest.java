package shop.mtcoding.todayhome.core.util;

import org.junit.jupiter.api.Test;
import shop.mtcoding.todayhome.user.User;

public class JwtUtilTest {

    @Test
    public void create_test() {
        User user = User.builder().id(1).username("ssar").build();

        String accessToken = JwtUtil.create(user);
        System.out.println(accessToken);
    }

    @Test
    public void verify_test() {
        String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6MSwiZXhwIjoxNzI5NDMwODg1LCJ1c2VybmFtZSI6InNzYXIifQ.2Ie8UUr8YtFOupdJW1kPUsaKZ3HC8tV6NGRwz7-GUUwr4o7lH-VhZrUhV9_XWXSMoI8d7kzbTmKODYITMSd69Q";

        User user = JwtUtil.verify(accessToken);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
    }
}
