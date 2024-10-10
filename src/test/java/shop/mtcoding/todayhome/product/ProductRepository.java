package shop.mtcoding.todayhome.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepository {

    @Autowired
    private ProductRepository productRepository;
}
