package shop.mtcoding.todayhome.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.todayhome.order.OrderRepository;
import shop.mtcoding.todayhome.ready.ReadyRepository;

import java.util.List;

@DataJpaTest
public class CartRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ReadyRepository readyRepository;

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void test(){
        int id = 1;
        List<CartResponse.DTO> cartList = cartRepository.findByUserId(id);
        System.out.println(cartList.toString());
    }


}
