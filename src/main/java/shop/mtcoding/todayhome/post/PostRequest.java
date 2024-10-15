package shop.mtcoding.todayhome.post;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import shop.mtcoding.todayhome.user.User;

public class PostRequest {
    @Data
    public static class SaveDTO { // title, content 2개만 담으면 된다.
        //@Pattern(regexp = ) 정규표현식 패턴
        @NotEmpty
        private String title;
        @NotEmpty(message = "비워놓지마. (근데 이거 안써줘도 됨)")
        private String content;

        private int id;

        private int price;

        private String mainPhoto;
        public Post toEntity(User sessionUser) {
            return Post.builder()
                    .title(title)
                    .content(content)
                    .price(price)
                    .mainPhoto(mainPhoto)
                    .user(sessionUser)  // 작성자 정보 추가
                    .build();
        }
    }
}
