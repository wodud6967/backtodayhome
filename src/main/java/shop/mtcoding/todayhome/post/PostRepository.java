package shop.mtcoding.todayhome.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.mtcoding.todayhome.option.Option;
import shop.mtcoding.todayhome.product.Product;
import shop.mtcoding.todayhome.productoption.ProductOption;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {


    @Query("SELECT p " +
            "FROM Post p " +
            "LEFT JOIN Product pr ON p.id = pr.post.id " +
            "LEFT JOIN Inventory i ON pr.id = i.product.id " +
            "LEFT JOIN OrderDetail od ON i.id = od.inventory.id " +
            "GROUP BY p.id " +
            "ORDER BY COALESCE(SUM(od.count), 0) DESC")
    List<Post> findAllPostsOrderBySales();

    @Query("SELECT DISTINCT p FROM Post p LEFT JOIN FETCH p.reviews r ORDER BY p.createdAt DESC")
    List<Post> findAllPostsOrderByCreatedAtDesc();



    @Query("SELECT o FROM Option o "
            + "JOIN ProductOption po ON po.option.id = o.id "
            + "JOIN Product p ON po.product.id = p.id "
            + "WHERE po.priority = 1 "
            + "GROUP BY o.content, po.priority "
            + "ORDER BY po.priority")
    List<Option> findFirstPriorityOptionsByPriority();

    @Query("SELECT po FROM ProductOption po "
            + "JOIN po.option o "
            + "JOIN po.product p "
            + "WHERE po.priority = 2 "
            + "ORDER BY p.id")
    List<ProductOption> findChildOptionsByPriority();

    @Query("SELECT p FROM Product p "
            + "WHERE p.id NOT IN (SELECT po.product.id FROM ProductOption po) "
            + "ORDER BY p.id")
    List<Product> findAdditionalProducts();


    @Query("SELECT p FROM Post p WHERE p.subCategory.id = :categoryId")
    List<Post> findAllByCategoryId(int categoryId);

}
