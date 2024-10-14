package shop.mtcoding.todayhome.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("select p from Payment p join fetch p.order where p.tid = :tid")
    Optional<Payment> mFindByTid(@Param("tid") String tid);

}
