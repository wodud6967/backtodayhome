package shop.mtcoding.todayhome.product;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.brand.Brand;
import shop.mtcoding.todayhome.option.Option;
import shop.mtcoding.todayhome.photo.Photo;
import shop.mtcoding.todayhome.post.Post;

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

    private String name;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Option>  option;


    @Builder
    public Product(int id, String name, int price, Post post, List<Option> option) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.post = post;
        this.option = option;
    }
}
