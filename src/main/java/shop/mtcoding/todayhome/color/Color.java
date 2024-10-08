package shop.mtcoding.todayhome.color;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "color_tb")
@NoArgsConstructor
@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String colorName;



    @Builder
    public Color(int id, String colorName) {
        this.id = id;
        this.colorName = colorName;
    }
}
