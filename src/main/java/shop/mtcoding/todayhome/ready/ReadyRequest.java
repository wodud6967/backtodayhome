package shop.mtcoding.todayhome.ready;

import lombok.Builder;
import lombok.Data;
import shop.mtcoding.todayhome.order.Order;

public class ReadyRequest {

    @Data
    public static class ReadyDTO {
        private String cid;
        private String partnerOrderId;
        private String partnerUserId;
        private String itemName;
        private int quantity;
        private int totalAmount;
        private int taxFreeAmount;
        private String approvalUrl;
        private String failUrl;
        private String cancelUrl;

        @Builder
        public ReadyDTO(Order order, Ready ready) {
            this.cid = ready.getCid();
            this.partnerOrderId = order.getPartnerOrderId();
            this.partnerUserId = order.getUser().getUsername();
            this.itemName = order.getOrderDetail().getFirst().getProduct().getName();
            this.quantity = order.getQuantity();
            this.totalAmount = order.getTotalAmount();
            this.taxFreeAmount = ready.getTaxFreeAmount();
            this.approvalUrl = ready.getApprovalUrl();
            this.failUrl = ready.getFailUrl();
            this.cancelUrl = ready.getCancelUrl();
        }
    }

}
