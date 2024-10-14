package shop.mtcoding.todayhome.order;

import lombok.Data;
import shop.mtcoding.todayhome.inventory.Inventory;
import shop.mtcoding.todayhome.orderdetail.OrderDetail;
import shop.mtcoding.todayhome.user.User;

import java.util.List;

public class OrderRequest {

    @Data
    public static class SaveOrderDetailDTO{
        private Order order;
        private Inventory inventory;


        public OrderDetail toEntity(Order order, Inventory inventory, OrderDetailDTO orderDetailDTO){
            return OrderDetail.builder()
                    .order(order)
                    .inventory(inventory)
                    .count(orderDetailDTO.getCount())
                    .price(orderDetailDTO.getPrice())
                    .totalPrice(orderDetailDTO.getPrice())
                    .build();
        }

    }

    @Data
    public static class SaveOrderDTO{

        private String partnerOrderId;
        private int totalAmount;
        private int quantity;

        public Order toEntity(String partnerOrderId, User sessoinUser, int totalAmount, int quantity){
            return Order.builder()
                    .partnerOrderId(partnerOrderId)
                    .user(sessoinUser)
                    .totalAmount(totalAmount)
                    .quantity(quantity)
                    .build();
        }


    }

    @Data
    public static class DTO {

        private int totalAmount;
        private int quantity;
        private List<OrderRequest.OrderDetailDTO> details;

        public DTO(int totalAmount, int quantity, List<OrderDetailDTO> details) {
            this.totalAmount = totalAmount;
            this.quantity = quantity;
            this.details = details;
        }
    }

    @Data
    public static class OrderDetailDTO {
        private int inventoryId;
        private int count;
        private int price;
        private int totalPrice;

        public OrderDetailDTO(int inventoryId, int count, int price, int totalPrice) {
            this.inventoryId = inventoryId;
            this.count = count;
            this.price = price;
            this.totalPrice = totalPrice;
        }
    }

}
