package shop.mtcoding.todayhome.core.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import shop.mtcoding.todayhome.user.User;

import java.util.Date;

public class JwtUtil {
    public static String create(User user){
        String accessToken = JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + 2000 * 60 * 60 * 25 * 7))
                .withClaim("id",user.getId())
                .withClaim("username", user.getUsername())
                .sign(Algorithm.HMAC512("비밀번호모르겠지"));
        return accessToken;
    }

    public static User verify(String jwt){

        jwt = jwt.replace("Bearer ", "").trim();


        DecodedJWT decodedJWT = null;
        try {
           decodedJWT = JWT.require(Algorithm.HMAC512("비밀번호모르겠지")).build().verify(jwt);

            int id = decodedJWT.getClaim("id").asInt();
            System.out.println("토큰 검증중 id: " + id);
        } catch (com.auth0.jwt.exceptions.TokenExpiredException e) {
            //만료기간 확인
            System.out.println("Token has expired 토큰이 만료됨");
            e.printStackTrace();
        } catch (com.auth0.jwt.exceptions.SignatureVerificationException e) {
            System.out.println("Invalid signature");
            e.printStackTrace();
        } catch (com.auth0.jwt.exceptions.JWTVerificationException e) {
            System.out.println("JWT verification failed");
            e.printStackTrace();
        }

        int id = decodedJWT.getClaim("id").asInt();

        String username = decodedJWT.getClaim("username").asString();


        return User.builder()
                .id(id)
                .username(username)
                .build();
    }
}
