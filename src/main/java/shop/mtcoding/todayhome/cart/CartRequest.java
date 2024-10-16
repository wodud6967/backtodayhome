package shop.mtcoding.todayhome.cart;

import lombok.Data;
import shop.mtcoding.todayhome.inventory.Inventory;
import shop.mtcoding.todayhome.user.User;

public class CartRequest {

    @Data
    public static class DTO {
        private int inventoryId;
        private int price;
        private int totalPrice;

        public DTO(int inventoryId, int price, int totalPrice) {
            this.inventoryId = inventoryId;
            this.price = price;
            this.totalPrice = totalPrice;
        }
    }

    @Data
    public static class SaveCartDTO {
        public User user;
        private int inventoryId;
        public int count;
        private int price;
        private int totalPrice;


        public Cart toEntity(User user, Inventory inventory, int count, int price, int totalPrice) {
            return Cart.builder()
                    .user(user)
                    .inventory(inventory)
                    .count(count)
                    .price(price)
                    .totalPrice(totalPrice)
                    .build();
        }
    }

}
