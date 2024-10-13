package shop.mtcoding.todayhome.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi403;
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
        // 1. Post 조회 (없으면 404)
        Post postPS = postRepository.findById(saveDTO.getPostId())
                .orElseThrow(() -> new ExceptionApi404("상품 페이지를 찾을 수 없습니다."));

        // 2. 비영속 리뷰 객체 만들기
        Review review = saveDTO.toEntity(sessionUser, postPS);

        // 3. 리뷰 저장 (review 가 영속화됨)
        reviewRepository.save(review);
        return new ReviewResponse.DTO(review);
    }

    @Transactional
    public ReviewResponse.DTO 리뷰수정(int id, ReviewRequest.UpdateDTO updateDTO, User sessionUser) {
        // 1. 리뷰 조회 (없으면 404)
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ExceptionApi404("작성한 리뷰를 찾을 수 없습니다."));

        // 2. 권한 체크
        if (review.getUser().getId() != sessionUser.getId()) {
            throw new ExceptionApi403("리뷰를 수정할 권한이 없습니다.");
        }

        // 3. 리뷰 수정 (더티체킹, DB에 수정 반영)
        review.setStar(updateDTO.getStar());
        review.setContent(updateDTO.getContent());
        review.setUrl(updateDTO.getUrl());

        return new ReviewResponse.DTO(review);
    }
}
