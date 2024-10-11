package shop.mtcoding.todayhome.photo;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.post.Post;

@Getter
@Setter
@Table(name = "photo_tb")
@NoArgsConstructor
@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;

    // 사진의 용도를 나타내는 필드 (예: 썸네일, 상세, 메인 등)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;


    @Builder
    public Photo(int id, String url, Post post) {
        this.id = id;
        this.url = url;
        this.post = post;
    }
}
