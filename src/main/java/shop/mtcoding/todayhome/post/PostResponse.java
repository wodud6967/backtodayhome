package shop.mtcoding.todayhome.post;

import jakarta.persistence.*;
import jakarta.servlet.http.PushBuilder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.todayhome.product.Product;
import shop.mtcoding.todayhome.review.Review;
import shop.mtcoding.todayhome.user.User;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostResponse {
    @Data
    public static class ListDTO {
        private Integer selectedCategory;
        private String testString = "테스트중";
        private List<RecentPostsDTO> recentPostsDTOS = new ArrayList<>();
        private List<PageTotalSoldDto> pageTotalSoldDtos = new ArrayList<>();

        public ListDTO(List<Post> recentPosts, List<Post> bestSellingPosts) {
            for (Post post : recentPosts) {
                this.recentPostsDTOS.add(new RecentPostsDTO(post));
            }
            for (Post post : bestSellingPosts) {
                this.pageTotalSoldDtos.add(new PageTotalSoldDto(post));
            }
        }

        @Data
        public class RecentPostsDTO {
            private String title;
            private String content;
            private int price;
            private String mainPhoto;
            private Timestamp createdAt;
            private List<ReviewDto> reviews = new ArrayList<>();

            public RecentPostsDTO(Post post) {
                this.title = post.getTitle();
                this.content = post.getContent();
                this.price = post.getPrice();
                this.mainPhoto = post.getMainPhoto();
                this.createdAt = post.getCreatedAt();

                // 리뷰 데이터 추가
                for (Review review : post.getReviews()) {
                    this.reviews.add(new ReviewDto(review));
                }
            }
        }

        @Data
        public class PageTotalSoldDto {
            private String title;
            private String content;
            private int price;
            private String mainPhoto;
            private Timestamp createdAt;
            private List<ReviewDto> reviews = new ArrayList<>();

            public PageTotalSoldDto(Post post) {
                this.title = post.getTitle();
                this.content = post.getContent();
                this.price = post.getPrice();
                this.mainPhoto = post.getMainPhoto();
                this.createdAt = post.getCreatedAt();

                // 리뷰 데이터 추가
                for (Review review : post.getReviews()) {
                    this.reviews.add(new ReviewDto(review));
                }
            }
        }

        @Data
        public static class ReviewDto {
            private int id;
            private String content;
            private String url;
            private Double star;
            private String createdAt;

            public ReviewDto(Review review) {
                this.id = review.getId();
                this.content = review.getContent();
                this.url = review.getImgUrl();
                this.star = review.getStar();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                this.createdAt = review.getCreatedAt().toLocalDateTime().format(formatter);
            }
        }
    }
}