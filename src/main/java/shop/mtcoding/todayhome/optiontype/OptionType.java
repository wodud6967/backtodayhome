package shop.mtcoding.todayhome.optiontype;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Table(name = "optiontype_tb")
@NoArgsConstructor
@Entity
public class OptionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    @Builder
    public OptionType(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
