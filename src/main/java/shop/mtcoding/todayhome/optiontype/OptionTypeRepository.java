package shop.mtcoding.todayhome.optiontype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OptionTypeRepository extends JpaRepository<OptionType, Integer> {


    // 옵션 유형을 type 필드로 검색하는 메서드
    Optional<OptionType> findByType(String type);
}
