package shop.mtcoding.todayhome.post;

import lombok.Data;
import shop.mtcoding.todayhome.product.Product;

import java.util.ArrayList;
import java.util.List;

public class PostDetailResponse {

    @Data
    public static class PostDTO {
        private int id;
        private String title;
        private String content;
        private int price;
        private String mainPhoto;
        private List<OptionGroupDTO> optionGroups = new ArrayList<>(); // 옵션 그룹

        public PostDTO() {}

        public PostDTO(int id, String title, String content, int price, String mainPhoto) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.price = price;
            this.mainPhoto = mainPhoto;
        }
    }

    @Data
    public static class OptionGroupDTO {
        private String optionName; // 옵션 이름 (예: 사이즈, 색상, 추가상품)
        private List<OptionValueDTO> values = new ArrayList<>(); // 옵션 값 리스트
    }

    @Data
    public static class OptionValueDTO {
        private int id; // 옵션 ID
        private String optionValue; // 옵션 값 (예: 사이즈, 색상)
        private String priceRange; // 가격 범위
        private int price; // 가격
        private int postId; // 관련 게시물 ID

        public OptionValueDTO(int id, String optionValue, String priceRange, int price, int postId) {
            this.id = id;
            this.optionValue = optionValue;
            this.priceRange = priceRange;
            this.price = price;
            this.postId = postId;
        }
    }
}