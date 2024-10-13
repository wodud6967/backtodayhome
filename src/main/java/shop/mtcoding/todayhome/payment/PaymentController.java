package shop.mtcoding.todayhome.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.todayhome.core.util.Resp;

@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/pay/approve")
    public ResponseEntity<?> payApprove(@RequestParam("pg_token") String pgToken) {
        paymentService.payApprove(pgToken);
        return ResponseEntity.ok(Resp.ok("결제 완료"));
    }

}
