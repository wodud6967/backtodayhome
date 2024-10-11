package shop.mtcoding.todayhome.option;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.optiontype.OptionType;
import shop.mtcoding.todayhome.product.Product;


@Getter
@Setter
@Table(name = "option_tb")
@NoArgsConstructor
@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private OptionType optionType;

    @Builder
    public Option(int id, String content, int price, Product product, OptionType optionType) {
        this.id = id;
        this.content = content;
        this.price = price;
        this.product = product;
        this.optionType = optionType;
    }
}
