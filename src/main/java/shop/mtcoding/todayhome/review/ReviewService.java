package shop.mtcoding.todayhome.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi403;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;
import shop.mtcoding.todayhome.core.util.MyFileUtil;
import shop.mtcoding.todayhome.post.Post;
import shop.mtcoding.todayhome.post.PostRepository;
import shop.mtcoding.todayhome.user.User;

import java.io.IOException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final PostRepository postRepository;


    @Transactional
    public ReviewResponse.DTO 리뷰쓰기(int id, ReviewRequest.SaveDTO saveDTO, User sessionUser) {
        // 1. Post 조회 (없으면 404)
        Post postPS = postRepository.findById(id)
                .orElseThrow(() -> new ExceptionApi404("상품 페이지를 찾을 수 없습니다."));

        // 2. base64 -> file 저장
        String imgUrl = null;
        try {
            imgUrl = MyFileUtil.파일저장(saveDTO.getImgUrl());
        } catch (Exception e) {
            e.printStackTrace();
            imgUrl = "/images/noImg.png";
        }

        // DB 에 저장할 때, 경로 없이 저장
        String fileNameOnly = imgUrl.substring("./images/".length()); // 앞의 "./images/" 부분 제거

        // 3. file 경로 가져와서 + 사진경로 DB 저장 + 비영속 리뷰 객체 만들기
        Review review = saveDTO.toEntity(sessionUser, postPS, fileNameOnly);

        // 4. 리뷰 저장 (review 가 영속화됨)
        reviewRepository.save(review);
        return new ReviewResponse.DTO(review);
    }

    @Transactional
    public ReviewResponse.UpdateDTO 리뷰수정(int id, ReviewRequest.UpdateDTO updateDTO, User sessionUser) {
        // 1. 리뷰 조회 (없으면 404)
        Review reviewPS = reviewRepository.findById(id)
                .orElseThrow(() -> new ExceptionApi404("작성한 리뷰를 찾을 수 없습니다."));

        // 2. 권한 체크
        if (reviewPS.getUser().getId() != sessionUser.getId()) {
            throw new ExceptionApi403("리뷰를 수정할 권한이 없습니다.");
        }

        // 3. 리뷰 수정 (더티체킹, DB에 수정 반영)
        reviewPS.setStar(updateDTO.getStar());
        reviewPS.setContent(updateDTO.getContent());
//        reviewPS.setImgUrl(updateDTO.getImgBase64());

        return new ReviewResponse.UpdateDTO(reviewPS);
    }

    @Transactional
    public void 리뷰삭제(int id, User sessionUser) {
        // 1. 리뷰 조회 (없으면 404)
        Review reviewPS = reviewRepository.findById(id)
                .orElseThrow(() -> new ExceptionApi404("삭제할 리뷰를 찾을 수 없습니다."));

        // 2. 권한 체크
        if (reviewPS.getUser().getId() != sessionUser.getId()) {
            throw new ExceptionApi403("리뷰 삭제 권한이 없습니다.");
        }

        reviewRepository.deleteById(id);
    }
}
