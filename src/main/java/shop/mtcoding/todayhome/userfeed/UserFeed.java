package shop.mtcoding.todayhome.userfeed;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.post.Post;
import shop.mtcoding.todayhome.user.User;
import shop.mtcoding.todayhome.userfeedphoto.UserFeedPhoto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "userfeed_tb")
@NoArgsConstructor
@Entity
public class UserFeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 카테고리 (임의작성)
    private String category;

    // 멘트
    private String content;

    // 날짜 (임의작성)
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @OneToMany(mappedBy = "userFeed", fetch = FetchType.LAZY)
    private List<UserFeedPhoto> feedPhotos = new ArrayList<>();

    @Builder
    public UserFeed(int id, String category, String content, String date, User user, Post post) {
        this.id = id;
        this.category = category;
        this.content = content;
        this.date = date;
        this.user = user;
        this.post = post;
    }
}
