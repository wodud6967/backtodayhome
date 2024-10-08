package shop.mtcoding.todayhome.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "user_tb")
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;//아이디

    private String password;

    @Column
    private String name;

    private int age;

    private String email;

    private String phone;

    private String address;

    private String oauth;

    @Builder
    public User(int id, String username, String password, String name, int age, String email, String phone, String address, String oauth) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.oauth = oauth;
    }
}
