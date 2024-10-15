package shop.mtcoding.todayhome.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("select o from Order o where o.partnerOrderId =:partnerOrderId")
    Order mfindByPartnerOrderId(@Param("partnerOrderId") String partnerOrderId);

    @Query("select o from Order o left join fetch o.orderDetail d left join fetch d.inventory i left join fetch i.product p left join fetch p.post " +
            "left join fetch  p.post.brand left join fetch o.user  where o.partnerOrderId =:partnerOrderId")
    OrderResponse.DTO mfindOrderPage(@Param("partnerOrderId") String partnerOrderId);


}
