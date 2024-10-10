package shop.mtcoding.todayhome.product;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.brand.Brand;
import shop.mtcoding.todayhome.photo.Photo;
import shop.mtcoding.todayhome.option.Option;

import java.util.List;

@Getter
@Setter
@Table(name = "product_tb")
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;

    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @OneToMany(mappedBy ="product", fetch = FetchType.LAZY)
    private List<Option> options;


    @OneToMany(mappedBy ="product", fetch = FetchType.LAZY)
    private List<Photo> photos;

    @Builder
    public Product(int id, String title, String content, String productName, Brand brand, List<Option> options, List<Photo> photos) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.productName = productName;
        this.brand = brand;
        this.options = options;
        this.photos = photos;
    }
}
