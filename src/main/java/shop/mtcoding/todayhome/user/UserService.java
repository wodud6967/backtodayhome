package shop.mtcoding.todayhome.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi401;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;
import shop.mtcoding.todayhome.core.util.JwtUtil;
import shop.mtcoding.todayhome.inventory.Inventory;
import shop.mtcoding.todayhome.inventory.InventoryRepository;
import shop.mtcoding.todayhome.userfeed.UserFeed;
import shop.mtcoding.todayhome.userfeed.UserFeedRepository;

import java.util.ArrayList;
import java.util.List;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final InventoryRepository inventoryRepository;
    private final UserFeedRepository userFeedRepository;

    public UserResponse.UserDTO 나의피드조회(User sessionUser) {
        // 1. 유저 조회 (유저+피드 JOIN 됨)


        User userPS = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new ExceptionApi404("유저 정보를 찾을 수 없습니다람쥐."));

        UserResponse.UserDTO myUser = new UserResponse.UserDTO(userPS);

        List<UserFeed> userFeeds = userFeedRepository.findAll();

        List<UserResponse.UserDTO.UserFeedDTO> userFeedDTOs = new ArrayList<>();

        for (UserFeed feed : userFeeds) {
            userFeedDTOs.add(new UserResponse.UserDTO.UserFeedDTO(feed));
        }


        myUser.getUserFeeds().addAll(userFeedDTOs);


        return myUser;
    }

    public UserResponse.UserOrderDTO 나의주문조회(User sessionUser) {

        // 1. 유저 조회
        User userPS = userRepository.teacherFind(sessionUser.getId())
                .orElseThrow(() -> new ExceptionApi404("유저 정보를 찾을 수 없습니다."));

        // 2. 유저의 모든 주문을 DTO에 옮기기
        UserResponse.UserOrderDTO userOrderDTO = new UserResponse.UserOrderDTO(userPS);

        // 3. 인벤토리 ID 추출 (user, order, orderDetail(인벤토리ID있음)) -> (inventory)
        List<Integer> ids = new ArrayList<>();
        for (UserResponse.UserOrderDTO.MyOrderDTO myOrderDTO : userOrderDTO.getDetails()) {
            for (UserResponse.UserOrderDTO.MyOrderDetailDTO myOrderDetailDTO : myOrderDTO.getOrderDetails()) {

                int inventoryId = myOrderDetailDTO.getInventoryId();
                ids.add(inventoryId);

            }
        }
        // 4. 인벤토리 데이터 조회
        List<Inventory> invens = inventoryRepository.findByIdWithPostTitleAndMainPhotoV2(ids);

        // 5. 인벤토리 데이터를 OrderDetail 에 순차적으로 매핑
        for (UserResponse.UserOrderDTO.MyOrderDTO myOrderDTO : userOrderDTO.getDetails()) {
            for (UserResponse.UserOrderDTO.MyOrderDetailDTO myOrderDetailDTO : myOrderDTO.getOrderDetails()) {
                /// 인벤토리 리스트에서 순차적으로 꺼내서 매핑
                int inventoryId = myOrderDetailDTO.getInventoryId();

                // for 문을 사용하여 inventoryId와 일치하는 Inventory 객체 찾기
                for (Inventory inv : invens) {
                    if (inv.getId() == inventoryId) {
                        // postTitle과 postMainPhoto 설정
                        myOrderDetailDTO.setPostTitle(inv.getProduct().getPost().getTitle());
                        myOrderDetailDTO.setPostMainPhoto(inv.getProduct().getPost().getMainPhoto());
                    }
                }
            }
        }

        return userOrderDTO;

         // 3. 인벤토리 ID 추출 (리팩토링 전)
//        for (UserResponse.UserOrderDTO.MyOrderDTO myOrderDTO : userOrderDTO.getDetails()) {
//            for (UserResponse.UserOrderDTO.MyOrderDetailDTO myOrderDetailDTO : myOrderDTO.getOrderDetails()) {
//                int inventoryId = myOrderDetailDTO.getInventoryId();
//                // 인벤토리 ID 로 post 제목과 사진 들고오기 (JOIN 했음)
//                Inventory inventoryPS = inventoryRepository.findByIdWithPostTitleAndMainPhoto(inventoryId)
//                        .orElseThrow(() -> new ExceptionApi404("인벤토리 정보를 찾을 수 없습니다. Inventory ID: " + inventoryId));
//                String postTitle = inventoryPS.getProduct().getPost().getTitle();
//                String postMainPhoto = inventoryPS.getProduct().getPost().getMainPhoto();
//
//                myOrderDetailDTO.setPostTitle(postTitle);
//                myOrderDetailDTO.setPostMainPhoto(postMainPhoto);
//            }
//        }
//        return userOrderDTO;
    }

    public UserResponse.UserReviewDTO 나의리뷰조회(User sessionUser) {
        User userPS = userRepository.findById(sessionUser.getId())
                .orElseThrow(() -> new ExceptionApi404("유저 정보를 찾을 수 없습니다."));

        return new UserResponse.UserReviewDTO(userPS);
    }

    public UserResponse.LoginDTO 로그인(UserRequest.LoginDTO loginDTO) {
        User userPS = userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword())
                .orElseThrow(() -> new ExceptionApi401("아이뒤또는 이메일이 틀렸습니다."));

        String accessToken = JwtUtil.create(userPS);
        return new UserResponse.LoginDTO(accessToken, userPS);
    }
}
