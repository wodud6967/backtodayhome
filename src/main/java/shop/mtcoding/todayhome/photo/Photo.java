package shop.mtcoding.todayhome.photo;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.product.Product;

@Getter
@Setter
@Table(name = "photo_tb")
@NoArgsConstructor
@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;


    @Builder
    public Photo(int id, String url, Product product) {
        this.id = id;
        this.url = url;
        this.product = product;
    }
}
