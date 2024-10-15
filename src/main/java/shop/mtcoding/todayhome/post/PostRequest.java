package shop.mtcoding.todayhome.post;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import shop.mtcoding.todayhome.brand.Brand;
import shop.mtcoding.todayhome.subcategory.SubCategory;
import shop.mtcoding.todayhome.user.User;

import java.util.List;

public class PostRequest {
    @Data
    public static class SaveDTO { // title, content 2개만 담으면 된다.
        //@Pattern(regexp = ) 정규표현식 패턴
        @NotEmpty
        private String title;
        @NotEmpty(message = "비워놓지마. (근데 이거 안써줘도 됨)")
        private String content;

        private int id;

        private int price;

        private String mainPhoto;

        private int subCategoryId;

        private int brandId;

        private List<ProductDTO> products;

        @Data
        public static class ProductDTO {
            private String name;
            private int price;

            private List<OptionDTO> options;
            private List<InventoryDTO> inventory;
        }

        @Data
        public static class OptionDTO {
            private String optionType;  // 예: 사이즈, 색상
            private String optionValue; // 예: 싱글, 킹, 화이트, 블랙
            private int price;          // 옵션 가격
        }

        // 재고에 대한 DTO
        @Data
        public static class InventoryDTO {
            private int stock;          // 재고 수량
            private String option1Value; // 예: 싱글, 퀸 등 사이즈
            private String option2Value; // 예: 화이트, 블랙 등 색상
        }

        public Post toEntity(SubCategory subCategory, Brand brand,User sessionUser) {
            return Post.builder()
                    .title(title)
                    .content(content)
                    .price(price)
                    .mainPhoto(mainPhoto)
                    .subCategory(subCategory)
                    .brand(brand)
                    .user(sessionUser)  // 작성자 정보 추가
                    .build();
        }
    }
}
