package shop.mtcoding.todayhome.productoption;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.option.Option;
import shop.mtcoding.todayhome.product.Product;

@Getter
@Setter
@Table(name = "product_option_tb")
@NoArgsConstructor
@Entity
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id") // 외래 키
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id") // 외래 키
    private Option option;

    @Builder
    public ProductOption(int id, Product product, Option option) {
        this.id = id;
        this.product = product;
        this.option = option;
    }
}