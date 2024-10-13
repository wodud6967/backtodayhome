package shop.mtcoding.todayhome.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;
import shop.mtcoding.todayhome.post.Post;
import shop.mtcoding.todayhome.post.PostRepository;
import shop.mtcoding.todayhome.user.User;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final PostRepository postRepository;

    @Transactional
    public ReviewResponse.DTO 리뷰쓰기(ReviewRequest.SaveDTO saveDTO, User sessionUser) {
        // 1. Post 존재 유무 확인
        Post postPS = postRepository.findById(saveDTO.getPostId())
                .orElseThrow(() -> new ExceptionApi404("상품 페이지를 찾을 수 없습니다."));

        // 2. 비영속 리뷰 객체 만들기
        Review review = saveDTO.toEntity(sessionUser, postPS);

        // 3. 리뷰 저장 (review 가 영속화됨)
        reviewRepository.save(review);
        return new ReviewResponse.DTO(review);
    }
}
