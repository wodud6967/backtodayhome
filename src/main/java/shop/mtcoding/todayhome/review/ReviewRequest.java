package shop.mtcoding.todayhome.review;

import lombok.Data;
import shop.mtcoding.todayhome.post.Post;
import shop.mtcoding.todayhome.user.User;

public class ReviewRequest {

    @Data
    public static class SaveDTO {
        private Integer postId;
        private Double star;
        private String content;
        private String url; // 단건 이미지

        // INSERT INTO review_tb (post_id, user_id, content, url, star, created_at)
        // VALUES (5, 1, '듀오백 의자는 장시간 사용에도 편안함을 유지합니다.', 'review7.jpg', 4.5, CURRENT_TIMESTAMP);
        public Review toEntity(User sessionUser, Post post) {
            return Review.builder()
                    .user(sessionUser)
                    .post(post)
                    .star(star)
                    .content(content)
                    .url(url)
                    .build();
        }
    }




}
