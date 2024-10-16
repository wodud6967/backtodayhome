package shop.mtcoding.todayhome.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.todayhome.order.OrderRequest;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query("select c from Cart c left join fetch c.inventory i left join fetch i.product p left join fetch p.post left join fetch p.post.brand left join fetch c.user u where u.id =:id")
    List<CartResponse.DTO> findByUserId(@Param("id") int id);

    @Query("select c.id from Cart c where c.inventory.id =:inventoryId")
    int findCartByInventoryId(@Param("inventoryId") int inventoryId);

    @Query("SELECT c FROM Cart c WHERE c.id =:cartDTOList")
    List<Cart> findCountAndPriceByIds(@Param("cartDTOList") List<Integer> cartDTOList);
}
