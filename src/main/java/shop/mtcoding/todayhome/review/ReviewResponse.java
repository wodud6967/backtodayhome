package shop.mtcoding.todayhome.review;

import lombok.Data;

import java.sql.Timestamp;

public class ReviewResponse {

    @Data
    public static class DTO {
        private Integer id;
        private Double star;
        private String content;
        private String url;
        private Timestamp createdAt;

        public DTO(Review review) {
            this.id = review.getId();
            this.star = review.getStar();
            this.content = review.getContent();
            this.url = review.getUrl();
            this.createdAt = review.getCreatedAt();
        }
    }


}
