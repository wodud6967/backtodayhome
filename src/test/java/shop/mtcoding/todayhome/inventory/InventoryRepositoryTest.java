package shop.mtcoding.todayhome.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.todayhome.order.OrderRepository;
import shop.mtcoding.todayhome.ready.ReadyRepository;

@DataJpaTest
public class InventoryRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ReadyRepository readyRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    public void test(){

    }


}
