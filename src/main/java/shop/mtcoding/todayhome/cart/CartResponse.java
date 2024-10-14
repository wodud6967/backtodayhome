package shop.mtcoding.todayhome.cart;

import lombok.Data;

public class CartResponse {

    @Data
    public static class DTO{
        private int id;
        private int count;
        private int price;
        private int totalPrice;
        private int userId;

        private String name;
        private String title;
        private String content;
        private String mainphoto;

        private String brandName;

        public DTO(Cart cart) {
            this.id = cart.getId();
            this.count = cart.getCount();
            this.price = cart.getPrice();
            this.totalPrice = cart.getTotalPrice();
            this.userId = cart.getUser().getId();
            this.name = cart.getInventory().getProduct().getName();
            this.title = cart.getInventory().getProduct().getPost().getTitle();
            this.content = cart.getInventory().getProduct().getPost().getContent();
            this.mainphoto = cart.getInventory().getProduct().getPost().getMainPhoto();
            this.brandName = cart.getInventory().getProduct().getPost().getBrand().getBrandName();
        }
    }

}
