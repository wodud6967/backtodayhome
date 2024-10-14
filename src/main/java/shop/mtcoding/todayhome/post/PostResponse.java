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
            // 최근 올라온 게시물 리스트를 RecentPostsDTO로 변환
            for (Post post : recentPosts) {
                this.recentPostsDTOS.add(new RecentPostsDTO(post));
            }

            // 많이 팔린 게시물 리스트를 PageTotalSoldDto로 변환
            for (Post post : bestSellingPosts) {
                this.pageTotalSoldDtos.add(new PageTotalSoldDto(post));
            }
        }

        //최근이 올라온 공고
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
                for (Review review : post.getReviews()) {
                    this.reviews.add(new ReviewDto(review));
                }
            }

            }
        }

        public static class ReviewDto{

            private int id;
            private User user;
            private String content; // 리뷰 내용
            private String url; // 사진
            private Double star; // 별점
            private String createdAt;


            public ReviewDto(Review review) {
                this.id = review.getId();
                this.user = review.getUser();
                this.content = review.getContent();
                this.url = review.getImgUrl();
                this.star = review.getStar();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                this.createdAt = review.getCreatedAt().toLocalDateTime().format(formatter);

            }
        }

    }




