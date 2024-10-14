package shop.mtcoding.todayhome.post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Option2DTO {
    private Integer productId;
    private String content;
    private Integer price;
}