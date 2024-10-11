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


    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;


    @Builder
    public Photo(int id, String url, Post post) {
        this.id = id;
        this.url = url;
        this.post = post;
    }
}
