package shop.mtcoding.todayhome.post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdditionalProductDTO {
    private Integer productId;
    private String name;
    private Integer price;
}
