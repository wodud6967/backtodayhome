package shop.mtcoding.todayhome.post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Option1DTO {
    private String content;
    private Integer price;
    private Integer priority;
}
