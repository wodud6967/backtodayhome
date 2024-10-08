package shop.mtcoding.todayhome.option;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.color.Color;
import shop.mtcoding.todayhome.product.Product;
import shop.mtcoding.todayhome.subcategory.SubCategory;

@Getter
@Setter
@Table(name = "option_tb")
@NoArgsConstructor
@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;


    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategory subCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private int price;


    private int stock;


    @Builder
    public Option(int id, Color color, SubCategory subCategory, Product product, int price, int stock) {
        this.id = id;
        this.color = color;
        this.subCategory = subCategory;
        this.product = product;
        this.price = price;
        this.stock = stock;
    }
}
