package shop.mtcoding.todayhome.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username=:username and u.password=:password")
    Optional<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("select u from User u join fetch u.orders or where u.id = :id")
    Optional<User> teacherFind(@Param("id") int id);

    @Query("select u from User u join fetch u.reviews rv join fetch rv.post p where u.id = :id")
    Optional<User> teacherFindV2(@Param("id") int id);

}
