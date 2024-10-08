package shop.mtcoding.todayhome.orderdetail;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.option.Option;
import shop.mtcoding.todayhome.order.Order;
import shop.mtcoding.todayhome.user.User;

@Getter
@Setter
@Table(name = "orderdetail_tb")
@NoArgsConstructor
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    private Option option;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private int price;
    private int totalPrice;
    private int count;


    @Builder
    public OrderDetail(int id, Option option, Order order, int price, int totalPrice, int count) {
        this.id = id;
        this.option = option;
        this.order = order;
        this.price = price;
        this.totalPrice = totalPrice;
        this.count = count;
    }
}
