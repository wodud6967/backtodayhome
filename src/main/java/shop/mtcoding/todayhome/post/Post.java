package shop.mtcoding.todayhome.post;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.brand.Brand;
import shop.mtcoding.todayhome.photo.Photo;
import shop.mtcoding.todayhome.option.Option;
import shop.mtcoding.todayhome.product.Product;
import shop.mtcoding.todayhome.subcategory.SubCategory;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Table(name = "post_tb")
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;

    private int price;

    private String mainPhoto;

    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategory subCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @OneToMany(mappedBy ="post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Photo> photos;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;

    @Builder
    public Post(int id, String title, String content, int price, String mainPhoto, Timestamp createdAt, SubCategory subCategory, Brand brand) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.price = price;
        this.mainPhoto = mainPhoto;
        this.createdAt = createdAt;
        this.subCategory = subCategory;
        this.brand = brand;

    }
}
