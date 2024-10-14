package shop.mtcoding.todayhome.orderdetail;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.inventory.Inventory;
import shop.mtcoding.todayhome.order.Order;
import shop.mtcoding.todayhome.product.Product;


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
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Inventory inventory;

    private int count;
    private int price;
    private int totalPrice;



    @Builder
    public OrderDetail(int id, Order order, Inventory inventory, int price, int totalPrice, int count) {
        this.id = id;
        this.order = order;
        this.inventory  = inventory;
        this.price = price;
        this.totalPrice = totalPrice;
        this.count = count;
    }
}
