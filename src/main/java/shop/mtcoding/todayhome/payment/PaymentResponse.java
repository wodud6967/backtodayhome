package shop.mtcoding.todayhome.payment;

import java.sql.Timestamp;
import java.util.Date;

public class PaymentResponse {

    public static class AmountDTO{
        private int total;
        private int tax_free;
        private int vat;

        public AmountDTO(int total, int taxFree, int vat) {
            this.total = total;
            this.tax_free = tax_free;
            this.vat = vat;
        }
    }

    public static class DTO {
        private String tid;
        private String partner_order_id;
        private String partner_user_id;
        private PaymentResponse.AmountDTO amount;

        public DTO(String tid, String partner_order_id, String partner_user_id, AmountDTO amount) {
            this.tid = tid;
            this.partner_order_id = partner_order_id;
            this.partner_user_id = partner_user_id;
            this.amount = amount;
        }
    }

}
