package shop.mtcoding.todayhome.core.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shop.mtcoding.todayhome.core.util.JwtUtil;
import shop.mtcoding.todayhome.core.util.Resp;
import shop.mtcoding.todayhome.user.User;

import java.io.IOException;
import java.io.PrintWriter;

public class JwtAuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String accessToken = req.getHeader("Authorization");

        if(accessToken == null || accessToken.isBlank()){
            System.out.println("토큰 없음");
            resp.setHeader("Content-Type","application/json; charset=utf-8");
            PrintWriter out = resp.getWriter();
            Resp fail = Resp.fail(401, "토큰이 없어요");
            String responseBody = new ObjectMapper().writeValueAsString(fail);
            out.println(responseBody);
            out.flush();
            return;


        }
        try {

            User sessionUser = JwtUtil.verify(accessToken);


            HttpSession session = req.getSession();
            session.setAttribute("sessionUser", sessionUser);
            chain.doFilter(req, resp);
        }catch (Exception e){
            resp.setHeader("Content-Type","application/json; charset=utf-8");
            PrintWriter out = resp.getWriter();
            Resp fail = Resp.fail(401, e.getMessage());
            String responseBody = new ObjectMapper().writeValueAsString(fail);
            out.println(responseBody);
            out.flush();

        }




    }

    private void failJWT(){

    }
}
