package shop.mtcoding.todayhome.ready;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;
import shop.mtcoding.todayhome.core.util.TempCode;
import shop.mtcoding.todayhome.order.Order;
import shop.mtcoding.todayhome.order.OrderRepository;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import shop.mtcoding.todayhome.payment.Payment;
import shop.mtcoding.todayhome.payment.PaymentRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ReadyService {

    private final OrderRepository orderRepository;
    private final ReadyRepository readyRepository;
    private final PaymentRepository paymentRepository;

    @Transactional
    public String 결제준비하기(int id){

        UUID tempCode = UUID.randomUUID();

        // 시크릿 키
        String secretKeyDev = "DEVE0E51377133628B9BF75F0644B4A09DAF4552";

        // 1. 결제 필요한 header 데이터
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "DEV_SECRET_KEY " + secretKeyDev);
        headers.set("Content-Type", "application/json");

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ExceptionApi404("주문내역을 찾을 수 없습니다"));

        String partnerOrderId = order.getPartnerOrderId();
        String partnerUserId = order.getUser().getName();
        String itemName = order.getOrderDetail().getFirst().getProduct().getName();
        int quantity = order.getQuantity();
        int totalAmount = order.getTotalAmount();

        // 2. 전송할 바디 설정
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");
        parameters.put("partner_order_id", partnerOrderId);
        parameters.put("partner_user_id", partnerUserId);
        parameters.put("item_name", itemName + " 외 " + String.valueOf(quantity-1) + "개");
        parameters.put("quantity", String.valueOf(quantity));
        parameters.put("total_amount", String.valueOf(totalAmount));
        parameters.put("tax_free_amount", "0");
        parameters.put("approval_url", "http://192.168.0.102:8080/pay/approve?tempCode="+tempCode.toString());
        parameters.put("cancel_url", "http://192.168.0.102:8080/pay/cancel");
        parameters.put("fail_url", "http://192.168.0.102:8080/pay/fail");

        // 3. 데이터 전송
        HttpEntity<Map<String, String>> entityMap = new HttpEntity<>(parameters, headers);

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";

        ResponseEntity<ReadyResponse.DTO> response = template.postForEntity(url, entityMap, ReadyResponse.DTO.class);

        // 4. 결제 테이블에 데이터 생성 후 TID 저장 및 세션에 저장
        Order od = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));
        String tid = response.getBody().getTid();

        TempCode.addTid(tempCode.toString(), tid);

        String pgToken = "";
        Payment payment = new Payment(od, tid, pgToken, totalAmount);
        paymentRepository.save(payment);

        // 5. response에서 이동할 모바일 주소만 뽑아오기
        String resUrl = response.getBody().getNext_redirect_mobile_url();
        String webUrl = response.getBody().getNext_redirect_pc_url();

        // 주문번호 id로 저장

        return resUrl;

    }

}
