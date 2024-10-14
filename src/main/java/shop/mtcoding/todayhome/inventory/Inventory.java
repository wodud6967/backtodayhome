package shop.mtcoding.todayhome.inventory;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.option.Option;
import shop.mtcoding.todayhome.product.Product;

@Getter
@Setter
@Table(name = "inventory_tb")
@NoArgsConstructor
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int stock; // 재고 수량

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product; // 해당 재고가 속한 상품

    // 첫 번째 옵션 (예: 사이즈)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option1_id")
    private Option option1;

    // 두 번째 옵션 (예: 색상)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option2_id")
    private Option option2;

    @Builder
    public Inventory(int id, int stock, Product product, Option option1, Option option2) {
        this.id = id;
        this.stock = stock;
        this.product = product;
        this.option1 = option1;
        this.option2 = option2;
    }
}