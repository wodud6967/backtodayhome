package shop.mtcoding.todayhome.inventory;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.product.Product;

@Getter
@Setter
@Table(name = "inventory_tb")
@NoArgsConstructor
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int stock; // 재고 수량

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product; // 해당 재고가 속한 상품

    @Builder
    public Inventory(int id, int stock, Product product) {
        this.id = id;
        this.stock = stock;
        this.product = product;
    }
}
