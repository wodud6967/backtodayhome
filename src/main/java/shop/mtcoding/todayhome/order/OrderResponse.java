package shop.mtcoding.todayhome.order;

import lombok.Data;
import shop.mtcoding.todayhome.orderdetail.OrderDetail;
import shop.mtcoding.todayhome.ready.Ready;
import shop.mtcoding.todayhome.user.User;

import java.util.List;

public class OrderResponse {

    @Data
    public static class DTO{
        private OrderResponse.OrderDTO order;
        private List<OrderResponse.OrderDetailDTO> orderDetails;

        public DTO(OrderDTO order, List<OrderDetailDTO> orderDetails) {
            this.order = order;
            this.orderDetails = orderDetails;
        }
    }

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
    public static class OrderDTO {
        private int orderId;
        private String partnerOrderId;
        private int totalAmount;
        private int quantity;
        private int userId;
        private String userName;
        private String phone;
        private String address;

        public OrderDTO(Order order) {
            this.orderId = order.getId();
            this.partnerOrderId = order.getPartnerOrderId();
            this.totalAmount = order.getTotalAmount();
            this.quantity = order.getQuantity();
            this.userId = order.getUser().getId();
            this.userName = order.getUser().getName();
            this.phone = order.getUser().getPhone();
            this.address = order.getUser().getAddress();
        }
    }

}
