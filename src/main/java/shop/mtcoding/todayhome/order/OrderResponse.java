package shop.mtcoding.todayhome.order;

import lombok.Data;
import shop.mtcoding.todayhome.orderdetail.OrderDetail;
import shop.mtcoding.todayhome.ready.Ready;
import shop.mtcoding.todayhome.user.User;

import java.util.List;

public class OrderResponse {

    @Data
    public static class OrderDetailDTO{
        private int inventoryId;
        private int count;
        private int price;
        private int totalPrice;
        private String name;
        private String mainPhoto;
        private String title;
        private String brandName;

        public OrderDetailDTO(OrderDetail orderDetail) {
            this.inventoryId = orderDetail.getInventory().getId();
            this.count = orderDetail.getCount();
            this.price = orderDetail.getPrice();
            this.totalPrice = orderDetail.getTotalPrice();
            this.name = orderDetail.getInventory().getProduct().getName();
            this.mainPhoto = orderDetail.getInventory().getProduct().getPost().getMainPhoto();
            this.title = orderDetail.getInventory().getProduct().getPost().getTitle();
            this.brandName = orderDetail.getInventory().getProduct().getPost().getBrand().getBrandName();
        }
    }

    @Data
    public static class DTO {
        private int orderId;
        private String partnerOrderId;
        private int totalAmount;
        private int quantity;
        private String userName;
        private String phone;
        private String address;
        private List<OrderDetailDTO> orderDetails;

        public DTO(Order order, User user, List<OrderDetailDTO> orderDetails) {
            this.orderId = order.getId();
            this.partnerOrderId = order.getPartnerOrderId();
            this.totalAmount = order.getTotalAmount();
            this.quantity = order.getQuantity();
            this.userName = user.getName();
            this.phone = user.getPhone();
            this.address = user.getAddress();
            this.orderDetails = orderDetails;
        }
    }

}
