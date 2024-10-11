package shop.mtcoding.todayhome.user;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class UserRequest {

    @Data
    public static class LoginDTO{

        @NotEmpty
        private String username;

        @NotEmpty
        private String passwrod;
    }
}
