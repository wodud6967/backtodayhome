package shop.mtcoding.todayhome.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.order.OrderRepository;
import shop.mtcoding.todayhome.ready.ReadyRepository;

import java.util.Optional;

@DataJpaTest
public class PaymentRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ReadyRepository readyRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    public void test(){
        String tid = "T70bcd41058063936fda";
        Optional<Payment> payment = paymentRepository.mFindByTid(tid);
        System.out.println(payment.toString());

    }


}
