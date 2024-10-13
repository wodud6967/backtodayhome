package shop.mtcoding.todayhome.option;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Integer> {
    List<Option> findByOptionType_Id(int optionTypeId);
}
