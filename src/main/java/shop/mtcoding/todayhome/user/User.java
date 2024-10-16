package shop.mtcoding.todayhome.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.todayhome.order.Order;
import shop.mtcoding.todayhome.photo.Photo;
import shop.mtcoding.todayhome.review.Review;
import shop.mtcoding.todayhome.userfeed.UserFeed;
import shop.mtcoding.todayhome.userfeedphoto.UserFeedPhoto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "user_tb")
@NoArgsConstructor
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;//아이디

    private String password;

    @Column
    private String name;

    private int age;

    private String email;

    private String phone;

    private String address;

    private String oauth;

    private String profileImgUrl;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserFeed> userFeeds = new ArrayList<>();

    // 권한 필드 (기본적으로 사용자 / 관리자 구분)
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        USER,   // 일반 사용자
        ADMIN   // 관리자
    }

    @Builder
    public User(int id, String username, String password, String name, int age, String email, String phone, String address, String oauth, String profileImgUrl, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.oauth = oauth;
        this.profileImgUrl = profileImgUrl;
        this.role = role;
    }
}
