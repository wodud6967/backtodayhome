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

    private String type;// 옵션의 유형 (예: 색상, 사이즈, 배터리 등)

    @Builder
    public OptionType(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
