package shop.mtcoding.todayhome.ready;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.todayhome.core.util.Resp;

@RequiredArgsConstructor
@RestController
public class ReadyController {

    private final ReadyService readyService;

    // 주문 번호 넘기기
    @GetMapping("/pay/ready/{id}")
    public ResponseEntity<?> payReady(@PathVariable("id") int id) {
        String resUrl = readyService.결제준비하기(id);
        return ResponseEntity.ok(Resp.ok(resUrl));
    }

}
