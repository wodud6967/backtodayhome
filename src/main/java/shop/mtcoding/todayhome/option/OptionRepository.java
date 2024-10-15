package shop.mtcoding.todayhome.option;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.mtcoding.todayhome.product.Product;

import java.util.List;
import java.util.Optional;

public interface OptionRepository extends JpaRepository<Option, Integer> {
    List<Option> findByOptionType_Id(int optionTypeId);

    // 옵션의 content로 검색하는 메서드
    Optional<Option> findByContent(String content);
    // 옵션 유형을 type 필드로 검색하는 메서드
    Optional<Option> findByContentAndProduct(String content, Product product);
}
