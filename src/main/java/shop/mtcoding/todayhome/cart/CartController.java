package shop.mtcoding.todayhome.cart;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.todayhome.core.util.Resp;
import shop.mtcoding.todayhome.user.User;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CartController {

    private final CartService cartService;
    private final HttpSession session;

    @GetMapping("/api/cart")
    public ResponseEntity<?> selectCart() {
        User user = (User) session.getAttribute("sessionUser");
        int id = user.getId();
        List<CartResponse.DTO> cartList = cartService.selectCart(id);
        return ResponseEntity.ok(Resp.ok(cartList,"장바구니 조회완료"));
    }

}
