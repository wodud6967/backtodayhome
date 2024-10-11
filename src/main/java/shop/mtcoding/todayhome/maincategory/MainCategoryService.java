package shop.mtcoding.todayhome.maincategory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MainCategoryService {

    private final MainCategoryRepository mainCategoryRepository;

    public List<MainCategoryResponse.MainCategoryDTO> 카테고리목록() {

        List<MainCategory> categories = mainCategoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new ExceptionApi404("카테고리를 찾을 수 없습니다.");
        }

        // Stream을 이용해 MainCategory 리스트를 MainCategoryDTO 리스트로 변환
        return categories.stream()
                .map(MainCategoryResponse.MainCategoryDTO::new) // 각 MainCategory를 DTO로 변환
                .toList(); // 결과를 List로 수집

    }
}
