package shop.mtcoding.todayhome.post;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.brand.Brand;
import shop.mtcoding.todayhome.photo.Photo;
import shop.mtcoding.todayhome.option.Option;
import shop.mtcoding.todayhome.review.Review;
import shop.mtcoding.todayhome.product.Product;
import shop.mtcoding.todayhome.subcategory.SubCategory;
import shop.mtcoding.todayhome.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    private User user;  // 공고 작성자

    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategory subCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @OneToMany(mappedBy ="post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>(); // NullPointerException 방지 위해 초기화

    @Builder
    public Post(int id, String title, String content, int price, String mainPhoto, Timestamp createdAt, User user, SubCategory subCategory, Brand brand) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.price = price;
        this.mainPhoto = mainPhoto;
        this.createdAt = createdAt;
        this.user = user;
        this.subCategory = subCategory;
        this.brand = brand;
    }
}
