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
    private Integer id;

    private Integer priority;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Option option;

    @Builder
    public ProductOption(Integer id, Integer priority, Product product, Option option) {
        this.id = id;
        this.priority = priority;
        this.product = product;
        this.option = option;
    }
}