package shop.mtcoding.todayhome.maincategory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.todayhome.core.util.Resp;
import shop.mtcoding.todayhome.user.User;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class MainCategoryController {


    private final HttpSession session;
    private final MainCategoryService mainCategoryService;

    @GetMapping("/api/categorys")
    public ResponseEntity<?> category(HttpServletRequest request){

        User sessionUser = (User)session.getAttribute("sessionUser");
        List<MainCategoryResponse.MainCategoryDTO> model = mainCategoryService.카테고리목록();


        // 기존 Access Token을 다시 응답 헤더에 포함 (필요한 경우)
        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + request.getHeader("Authorization")) // 토큰을 그대로 반환
                .body(Resp.ok(model));
    }
}
