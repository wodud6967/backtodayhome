package shop.mtcoding.todayhome.post;

import jakarta.servlet.http.PushBuilder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PostResponse {
    @Data
    public static class ListDTO{
        private Integer selectedCategory;
        private String testString = "테스트중";

        private List<RecentPostsDTO> recentPostsDTOS = new ArrayList<>();
        private List<PageTotalSoldDto> pageTotalSoldDtos =new ArrayList<>();

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

            public RecentPostsDTO(Post post) {
                this.title = post.getTitle();
                this.content = post.getContent();
                this.price = post.getPrice();
                this.mainPhoto = post.getMainPhoto();
                this.createdAt = post.getCreatedAt();

            }

        }

        @Data
        public class PageTotalSoldDto {
            private String title;
            private String content;
            private int price;
            private String mainPhoto;
            private Timestamp createdAt;

            public PageTotalSoldDto(Post post){
                this.title = post.getTitle();
                this.content = post.getContent();
                this.price = post.getPrice();
                this.mainPhoto = post.getMainPhoto();
                this.createdAt = post.getCreatedAt();

            }
        }

    }
    @Data
    public static class postDTO{

        private int id;
        private String title;
        private String content;
        private int price;
        private String mainPhoto;

    }

    @Data
    public  static class optionDTO{

    }



}
