package shop.mtcoding.todayhome.cart;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.option.Option;
import shop.mtcoding.todayhome.user.User;

@Getter
@Setter
@Table(name = "cart_tb")
@NoArgsConstructor
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Option option;

    private int count;

    private int price;

    private int totalPrice;

    @Builder
    public Cart(int id, User user, Option option, int count, int price, int totalPrice) {
        this.id = id;
        this.user = user;
        this.option = option;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
    }
}
