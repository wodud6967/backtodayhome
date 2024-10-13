package shop.mtcoding.todayhome.subcategory;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.maincategory.MainCategory;
import shop.mtcoding.todayhome.post.Post;

import java.util.List;

@Getter
@Setter
@Table(name = "subcategory_tb")
@NoArgsConstructor
@Entity
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private MainCategory mainCategory;

    @OneToMany(mappedBy ="subCategory", fetch = FetchType.LAZY)
    private List<Post> post;

    @Builder
    public SubCategory(int id, String name, MainCategory mainCategory) {
        this.id = id;
        this.name = name;
        this.mainCategory = mainCategory;

    }
}
