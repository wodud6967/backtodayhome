package shop.mtcoding.todayhome.post;

import lombok.Data;
import shop.mtcoding.todayhome.product.Product;

import java.util.ArrayList;
import java.util.List;

public  class PostSaveResponse  {

    @Data
    public  static  class DTO{
        private String title;
        private String content;
        private int price;
        private String mainPhoto;
        private List<ProductDTO> products =new ArrayList<>();

        // 생성자
        public DTO(Post post) {
            this.title = post.getTitle();
            this.content = post.getContent();
            this.price = post.getPrice();
            this.mainPhoto = post.getMainPhoto();

        }

    }


    // 내부 Product DTO
    @Data
    public static class ProductDTO {
        private String name;
        private int price;
        private List<OptionDTO> options;
        private List<InventoryDTO> inventory;

        public ProductDTO(Product product, List<OptionDTO> options, List<InventoryDTO> inventory) {
            this.name = product.getName();
            this.price = product.getPrice();
            this.options = options;
            this.inventory = inventory;
        }
    }

    // 내부 Option DTO
    @Data
    public static class OptionDTO {
        private String optionType;
        private String optionValue;
        private int price;

        public OptionDTO(String optionType, String optionValue, int price) {
            this.optionType = optionType;
            this.optionValue = optionValue;
            this.price = price;
        }
    }

    // 내부 Inventory DTO
    @Data
    public static class InventoryDTO {
        private String option1Value;
        private String option2Value;
        private int stock;

        public InventoryDTO(String option1Value, String option2Value, int stock) {
            this.option1Value = option1Value;
            this.option2Value = option2Value;
            this.stock = stock;
        }
    }
}

