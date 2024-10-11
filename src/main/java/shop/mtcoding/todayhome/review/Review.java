package shop.mtcoding.todayhome.review;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.post.Post;
import shop.mtcoding.todayhome.user.User;

import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "review_tb")
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private  String content;

    private  String url; // 사진

    private  double star;//별점

    private Timestamp createdAt;


    @Builder
    public Review(int id, Post post, User user, String content, String url, double star, Timestamp createdAt) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.content = content;
        this.url = url;
        this.star = star;
        this.createdAt = createdAt;
    }
}
