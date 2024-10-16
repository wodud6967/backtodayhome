package shop.mtcoding.todayhome.userfeedphoto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.userfeed.UserFeed;

@Getter
@Setter
@Table(name = "userfeedphoto_tb")
@NoArgsConstructor
@Entity
public class UserFeedPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 사진의 용도를 나타내는 필드 (ex. 대표이미지, 서브이미지)
    private String type;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserFeed userFeed;

    @Builder
    public UserFeedPhoto(int id, String type, String url, UserFeed userFeed) {
        this.id = id;
        this.type = type;
        this.url = url;
        this.userFeed = userFeed;
    }
}
