package shop.mtcoding.todayhome.brand;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.option.Option;
import shop.mtcoding.todayhome.user.User;

@Getter
@Setter
@Table(name = "brand_tb")
@NoArgsConstructor
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brandName;

}
