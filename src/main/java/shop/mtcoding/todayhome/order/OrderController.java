package shop.mtcoding.todayhome.order;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.todayhome.core.util.Resp;
import shop.mtcoding.todayhome.user.User;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;
    private final HttpSession session;

    @PostMapping("/api/order")
    public ResponseEntity<?> insertOrder(@RequestBody OrderRequest.DTO orderRequest) {
        User user = (User) session.getAttribute("sessionUser");
        OrderResponse.DTO orderPage = orderService.insertOrder(user, orderRequest);
        return ResponseEntity.ok(Resp.ok(orderPage,"주문서 생성 완료"));
    }

}
