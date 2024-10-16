package shop.mtcoding.todayhome.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.todayhome.maincategory.MainCategory;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Inventory findByProductIdAndOption1IdAndOption2Id(Integer productId, Integer option1Id, Integer option2Id);

    @Query("SELECT i FROM Inventory i WHERE i.product.post.id = :postId")
    List<Inventory> findByProductPostId(@Param("postId") Integer postId);

    // postId와 연관된 product 옵션이 모두 포함된 Inventory 목록을 가져옴
    @Query("SELECT i FROM Inventory i WHERE i.product.id = :productId AND i.option1.id = :option1Id AND (i.option2.id = :option2Id OR :option2Id IS NULL)")
    Inventory findByProductAndOptionIds(@Param("productId") Integer productId,
                                        @Param("option1Id") Integer option1Id,
                                        @Param("option2Id") Integer option2Id);

    // 마이 페이지-> 주문 내역에 필요한 post.title 과 post.mainphoto 를 가져가기 위함
    @Query("select i from Inventory i join fetch i.product p left join fetch p.post where i.id=:id")
    Optional<Inventory> findByIdWithPostTitleAndMainPhoto(@Param("id") int id);

    @Query("select i from Inventory i join fetch i.product p left join fetch p.post where i.id in :ids")
    List<Inventory> findByIdWithPostTitleAndMainPhotoV2(@Param("ids") List<Integer> ids);
}
