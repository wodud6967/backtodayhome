package shop.mtcoding.todayhome.order;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.user.User;

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

    private String merchantUid;

    @Builder
    public Order(int id, User user, String merchantUid) {
        this.id = id;
        this.user = user;
        this.merchantUid = merchantUid;
    }
}
