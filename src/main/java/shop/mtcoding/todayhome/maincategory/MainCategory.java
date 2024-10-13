package shop.mtcoding.todayhome.maincategory;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.todayhome.subcategory.SubCategory;

import java.util.List;

@Getter
@Setter
@Table(name = "maincategory_tb")
@NoArgsConstructor
@Entity
public class MainCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "mainCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SubCategory> subCategory;


    @Builder
    public MainCategory(int id, String name) {
        this.id = id;
        this.name = name;

    }
}
