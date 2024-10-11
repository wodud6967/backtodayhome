package shop.mtcoding.todayhome.user;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username=:username and u.password=:password")
    Optional<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String passwrod);
}
