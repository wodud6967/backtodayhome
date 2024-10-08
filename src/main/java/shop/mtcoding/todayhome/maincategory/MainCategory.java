package shop.mtcoding.todayhome.maincategory;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "maincategory_tb")
@NoArgsConstructor
@Entity
public class MainCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Builder
    public MainCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
