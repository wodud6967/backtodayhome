package shop.mtcoding.todayhome.user;

import lombok.Data;
import shop.mtcoding.todayhome.post.PostDetailResponse;
import shop.mtcoding.todayhome.review.Review;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {

    @Data // getter, setter, toString
    public static class UserReviewDTO {
        private Integer id;
        private String name;
        private List<MyReviewDTO> reviews = new ArrayList<>();

        @Data
        class MyReviewDTO {
            private Integer id;
            private String content;
            private Double star;
            private Integer postId; // 리뷰 작성 상품글 id
            private String postTitle; // 리뷰 작성 상품명 title

            public MyReviewDTO(Review review) {
                this.id = review.getId();
                this.content = review.getContent();
                this.star = review.getStar();
                this.postId = review.getPost().getId();
                this.postTitle = review.getPost().getTitle();
            }
        }

        public UserReviewDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();

            for (Review review : user.getReviews()) {
                reviews.add(new MyReviewDTO(review));
            }
        }

    }
}
