package shop.mtcoding.todayhome.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.todayhome.review.Review;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Data
public class PostDetailResponse {


    @Data
    @NoArgsConstructor
    public static class PostDTO {
        private int id;
        private String title;
        private String content;
        private int price;
        private String mainPhoto;
        private List<OptionGroupDTO> optionGroups = new ArrayList<>(); // 옵션 그룹 리스트
        private List<ReviewDTO> reviews = new ArrayList<>(); // 리뷰 리스트

        public PostDTO(Post post) {
            this.id = post.getId();
            this.title = post.getTitle();
            this.content = post.getContent();
            this.price = post.getPrice();
            this.mainPhoto = post.getMainPhoto();
        }
    }

    @Data
    @NoArgsConstructor
    public static class OptionGroupDTO {
        private String optionName; // 옵션 이름 (예: 사이즈, 색상, 추가상품)
        private Object values; // 값 리스트 또는 사이즈 ID별로 그룹화된 값

        public OptionGroupDTO(String optionName, Object values) {
            this.optionName = optionName;
            this.values = values;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OptionValueDTO {
        private Integer id; // 옵션 ID 또는 상품 ID
        private String optionValue; // 옵션 값 (예: 사이즈, 색상)
        private String priceRange; // 가격 범위 (예: "450,000 ~ 500,000")
        private int price; // 실제 가격
        private int postId; // 게시물 ID (옵션이나 상품이 속한 게시물)
    }

    @Data
    public static class ReviewDTO {
        private int id;
        private String content;
        private String url;
        private Double star;
        private String userName;
        private String createdAt;

        public ReviewDTO(Review review) {
            this.id = review.getId();
            this.content = review.getContent();
            this.url = review.getUrl();
            this.star = review.getStar();
            this.userName = review.getUser().getUsername(); // Assuming User has a getUsername() method
            // 날짜 형식 변환
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.createdAt = review.getCreatedAt().toLocalDateTime().format(formatter);

        }
    }
}