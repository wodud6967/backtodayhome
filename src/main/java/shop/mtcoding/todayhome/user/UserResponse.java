package shop.mtcoding.todayhome.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import shop.mtcoding.todayhome.order.Order;
import shop.mtcoding.todayhome.orderdetail.OrderDetail;
import shop.mtcoding.todayhome.post.PostDetailResponse;
import shop.mtcoding.todayhome.review.Review;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {

    @Data
    public static class UserOrderDTOV2 {
        private Integer id;
        private String name;
        private List<MyOrderDTO> details = new ArrayList<>();

        public UserOrderDTOV2(User user) {
            this.id = user.getId();
            this.name = user.getName();

            for (Order order : user.getOrders()) {
                details.add(new MyOrderDTO(order));
            }
        }

        @Data
        class MyOrderDetailDTO {
            private Integer id;
            private Integer inventoryId;
            private int count;
            private int price;
            private int totalPrice;

            private String postTitle; // 공고 title
            private String postMainPhoto; // 공고 사진

            public MyOrderDetailDTO(OrderDetail orderDetail) {
                this.id = orderDetail.getId();
                this.inventoryId = orderDetail.getInventory().getId();
                this.count = orderDetail.getCount();
                this.price = orderDetail.getPrice();
                this.totalPrice = orderDetail.getTotalPrice();
            }
        }

        @Data
        class MyOrderDTO {
            private Integer id;// 주문id
            private String partnerOrderId; // 주문번호
            private int totalAmount; // 총 가격
            private int quantity; // 총 수량
            private List<MyOrderDetailDTO> orderDetails = new ArrayList<>();

            public MyOrderDTO(Order order) {
                this.id = order.getId();
                this.partnerOrderId = order.getPartnerOrderId();
                this.totalAmount = order.getTotalAmount();
                this.quantity = order.getQuantity();

                for (OrderDetail orderDetail : order.getOrderDetail()) {
                    orderDetails.add(new MyOrderDetailDTO(orderDetail));
                }
            }
        }


    }

    @Data
    public static class UserOrderDTO {
        private Integer id;
        private String name;
        private List<MyOrderDTO> details = new ArrayList<>();

        public UserOrderDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();

            for (Order order : user.getOrders()) {
                details.add(new MyOrderDTO(order));
            }
        }

        @Data
        class MyOrderDetailDTO {
            private Integer id;
            private Integer inventoryId;
            private int count;
            private int price;
            private int totalPrice;

            private String postTitle; // 공고 title
            private String postMainPhoto; // 공고 사진

            public MyOrderDetailDTO(OrderDetail orderDetail) {
                this.id = orderDetail.getId();
                this.inventoryId = orderDetail.getInventory().getId();
                this.count = orderDetail.getCount();
                this.price = orderDetail.getPrice();
                this.totalPrice = orderDetail.getTotalPrice();
            }
        }

        @Data
        class MyOrderDTO {
            private Integer id;// 주문id
            private String partnerOrderId; // 주문번호
            private int totalAmount; // 총 가격
            private int quantity; // 총 수량
            private List<MyOrderDetailDTO> orderDetails = new ArrayList<>();

            public MyOrderDTO(Order order) {
                this.id = order.getId();
                this.partnerOrderId = order.getPartnerOrderId();
                this.totalAmount = order.getTotalAmount();
                this.quantity = order.getQuantity();

                for (OrderDetail orderDetail : order.getOrderDetail()) {
                    orderDetails.add(new MyOrderDetailDTO(orderDetail));
                }
            }
        }


    }

    @Data // getter, setter, toString
    public static class UserReviewDTO {
        private Integer id;
        private String name;
        private List<MyReviewDTO> reviews = new ArrayList<>();

        @Data
        class MyReviewDTO {
            private Integer id;
            private String content;
            private Double star;
            private Integer postId; // 리뷰 작성 상품글 id
            private String postTitle; // 리뷰 작성 상품명 title

            public MyReviewDTO(Review review) {
                this.id = review.getId();
                this.content = review.getContent();
                this.star = review.getStar();
                this.postId = review.getPost().getId();
                this.postTitle = review.getPost().getTitle();
            }
        }

        public UserReviewDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();

            for (Review review : user.getReviews()) {
                reviews.add(new MyReviewDTO(review));
            }
        }


    }
    record LoginDTO(@JsonIgnore String accessToken, Integer id, String username) {
        LoginDTO(String accessToken, User user) {
            this(accessToken, user.getId(), user.getUsername());
        }
    }
}
