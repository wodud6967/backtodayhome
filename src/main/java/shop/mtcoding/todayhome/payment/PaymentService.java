package shop.mtcoding.todayhome.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;
import shop.mtcoding.todayhome.core.util.TempCode;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    // 결제 승인 요청
    @Transactional
    public void payApprove(String pgToken, String tempCode) {

        // 메모리에 저장해놓은 tid 찾아오기
        String tid = TempCode.getTid(tempCode);
        Payment payment = paymentRepository.mFindByTid(tid)
                .orElseThrow(() -> new ExceptionApi404("세션을 찾을 수 없습니다"));

        String partnerOrderId = payment.getOrder().getPartnerOrderId();
        String partnerUserId = payment.getOrder().getUser().getName();

    // 시크릿 키
        String secretKeyDev = "DEVE0E51377133628B9BF75F0644B4A09DAF4552";

    // 1. 결제 필요한 header 데이터
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "DEV_SECRET_KEY " + secretKeyDev);
        headers.set("Content-Type", "application/json");

        // 2. 전송할 바디 설정
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");
        parameters.put("tid", tid);
        parameters.put("partner_order_id", partnerOrderId);
        parameters.put("partner_user_id", partnerUserId);
        parameters.put("pg_token", pgToken);

        // 3. 데이터 전송
        HttpEntity<Map<String, String>> entityMap = new HttpEntity<>(parameters, headers);

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/approve";

        ResponseEntity<PaymentResponse.DTO> response = template.postForEntity(url, entityMap, PaymentResponse.DTO.class);
        payment.setPgToken(pgToken);
        paymentRepository.save(payment);

    }

}
