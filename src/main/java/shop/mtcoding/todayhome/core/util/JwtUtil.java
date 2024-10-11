package shop.mtcoding.todayhome.core.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import shop.mtcoding.todayhome.user.User;

import java.util.Date;

public class JwtUtil {
    public static String create(User user){
        String accessToken = JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + 20000 * 60 * 60 * 25 * 7))
                .withClaim("id",user.getId())
                .withClaim("username", user.getUsername())
                .sign(Algorithm.HMAC512("비밀번호모르겠지"));
        return accessToken;
    }

    public static User verify(String jwt){
        jwt = jwt.replace("Bearer","");
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("비밀번호모르겠지")).build().verify(jwt);
        int id = decodedJWT.getClaim("id").asInt();
        String username = decodedJWT.getClaim("username").asString();

        return User.builder()
                .id(id)
                .username(username)
                .build();
    }
}
