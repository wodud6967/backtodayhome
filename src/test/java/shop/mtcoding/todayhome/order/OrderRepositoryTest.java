package shop.mtcoding.todayhome.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import shop.mtcoding.todayhome.ready.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ReadyRepository readyRepository;

 /*   @Test
    public void test(){
        String pid = "merchant_001";
        OrderResponse.DTO od = orderRepository.mfindOrderPage(pid);
        System.out.println(od.toString());
    }*/


}
