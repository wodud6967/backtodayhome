package shop.mtcoding.todayhome.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT p " +
            "FROM Post p " +
            "LEFT JOIN p.products pr " +
            "LEFT JOIN OrderDetail od ON pr.id = od.product.id " +
            "GROUP BY p " +
            "ORDER BY COALESCE(SUM(od.count), 0) DESC")
    List<Post> findAllPostsOrderBySales(Pageable pageable);

    //@Query("SELECT p FROM Post p ORDER BY p.createdAt DESC")
    //JPQL에서는에서는 직접적으로 TOP 또는 LIMIT을 지원하지 않으므로, Spring Data JPA의 네이밍 규칙을 활용해야
   //쿼리문을 주석안하면 모든 post가 다나온다.
    List<Post> findTop5ByOrderByCreatedAtDesc();


}
