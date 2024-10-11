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

    private String impUid;  //결제 내역 번호




    @Builder
    public Payment(int id, Order order, String impUid) {
        this.id = id;
        this.order = order;
        this.impUid = impUid;

    }
}
