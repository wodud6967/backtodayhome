package shop.mtcoding.todayhome.order;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.orderdetail.OrderDetail;
import shop.mtcoding.todayhome.user.User;

import java.util.List;

@Getter
@Setter
@Table(name = "order_tb")
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetail;

    private String merchantUid;

    @Builder
    public Order(int id, User user, List<OrderDetail> orderDetail, String merchantUid) {
        this.id = id;
        this.user = user;
        this.orderDetail = orderDetail;
        this.merchantUid = merchantUid;
    }
}
