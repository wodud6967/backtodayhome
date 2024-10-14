package shop.mtcoding.todayhome.review;

import lombok.Data;

import java.sql.Timestamp;

public class ReviewResponse {

    @Data
    public static class DTO {
        private Integer id;
        private Double star;
        private String content;
        private String imgUrl;
        private Timestamp createdAt;

        public DTO(Review review) {
            this.id = review.getId();
            this.star = review.getStar();
            this.content = review.getContent();
            this.imgUrl = review.getImgUrl();
            this.createdAt = review.getCreatedAt();
        }
    }

    @Data
    public static class UpdateDTO {
        private Integer id;
        private Double star;
        private String content;
        private Timestamp createdAt;

        public UpdateDTO(Review review) {
            this.id = review.getId();
            this.star = review.getStar();
            this.content = review.getContent();
            this.createdAt = review.getCreatedAt();
        }
    }


}
