package shop.mtcoding.todayhome.product;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.mtcoding.todayhome.post.Post;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
