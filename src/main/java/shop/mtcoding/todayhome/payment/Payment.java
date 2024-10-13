package shop.mtcoding.todayhome.payment;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.order.Order;

@Getter
@Setter
@Table(name = "payment_tb")
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private String tid;  //결제 내역 번호
    private String pgToken;
    private int totalAmount;

    @Builder
    public Payment(Order order, String tid, String pgToken, int totalAmount) {
        this.order = order;
        this.tid = tid;
        this.pgToken = pgToken;
        this.totalAmount = totalAmount;
    }
}
