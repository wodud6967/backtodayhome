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
        String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6MSwiZXhwIjoxNzI5NDA4ODU3LCJ1c2VybmFtZSI6InNzYXIifQ._tRqrCrKpSrQpaltMC1WCR8MRle5DcwAPuZj1BIsiYpRhTFsQZ2mfCTX9YAbfXO1ulKWEHnFMflTDH8AcDWRkg";
        User user = JwtUtil.verify(accessToken);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
    }
}
