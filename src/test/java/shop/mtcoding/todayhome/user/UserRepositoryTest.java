package shop.mtcoding.todayhome.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.todayhome.core.util.JwtUtil;
import shop.mtcoding.todayhome.inventory.Inventory;
import shop.mtcoding.todayhome.inventory.InventoryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    @Test
    public void teacherFind_test(){
        userRepository.teacherFindV2(1);
    }


    @Test
    public void findByIdWithPostTitleAndMainPhotoV2_test(){
        List<Integer> ids = Arrays.asList(1,2,3,4);
        List<Inventory> inventories = inventoryRepository.findByIdWithPostTitleAndMainPhotoV2(ids);
        System.out.println(inventories.size());
    }



    @Test
    public void login_test() {
        String username = "ssar";
        String password = "1234";

       Optional<User> user = userRepository.findByUsernameAndPassword(username, password);

        System.out.println(user.get().getEmail());

        String accessToken =  JwtUtil.create(user.get());

        System.out.println(accessToken);
    }

}
