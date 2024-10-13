package shop.mtcoding.todayhome.review;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.todayhome.core.util.Resp;
import shop.mtcoding.todayhome.user.User;

@RequiredArgsConstructor
@Controller
public class ReviewController {

    private final ReviewService reviewService;
    private final HttpSession session;

    @PostMapping("/api/review")
    public ResponseEntity<?> save(@RequestBody ReviewRequest.SaveDTO saveDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        ReviewResponse.DTO reviewDTO = reviewService.리뷰쓰기(saveDTO, sessionUser);
        return ResponseEntity.ok(Resp.ok(reviewDTO));
    }

    @PutMapping("/api/review/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ReviewRequest.UpdateDTO updateDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        ReviewResponse.DTO reviewDTO = reviewService.리뷰수정(id, updateDTO, sessionUser);
        return ResponseEntity.ok(Resp.ok(reviewDTO));
    }

    @DeleteMapping("/api/review/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        reviewService.리뷰삭제(id, sessionUser);
        return ResponseEntity.ok(Resp.ok("삭제, 성공적"));
    }

}
