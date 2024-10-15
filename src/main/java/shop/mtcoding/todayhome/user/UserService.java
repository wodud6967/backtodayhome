package shop.mtcoding.todayhome.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi401;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;
import shop.mtcoding.todayhome.core.util.JwtUtil;
import shop.mtcoding.todayhome.inventory.Inventory;
import shop.mtcoding.todayhome.inventory.InventoryRepository;
import shop.mtcoding.todayhome.order.Order;
import shop.mtcoding.todayhome.orderdetail.OrderDetail;
import shop.mtcoding.todayhome.review.Review;

import java.util.ArrayList;
import java.util.List;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final InventoryRepository inventoryRepository;

    private int inventoryId; // 인벤토리 ID
    private List<Integer> inventoryIds = new ArrayList<>(); // 인벤토리 ID 리스트
    private String postTitle;
    private String postMainPhoto;

    public UserResponse.UserOrderDTO 나의주문조회(User sessionUser) {

        User userPS = userRepository.findById(sessionUser.getId())
                .orElseThrow(() -> new ExceptionApi404("유저 정보를 찾을 수 없습니다."));

        UserResponse.UserOrderDTO userOrderDTO = new UserResponse.UserOrderDTO(userPS);
//        int inventoryId = userOrderDTO.getDetails().get(0).getOrderDetails().get(0).getInventoryId();
//        System.out.println(inventoryId);

        // 인벤토리 ID 추출
        for (UserResponse.UserOrderDTO.MyOrderDTO myOrderDTO : userOrderDTO.getDetails()) {
            for (UserResponse.UserOrderDTO.MyOrderDetailDTO myOrderDetailDTO : myOrderDTO.getOrderDetails()) {
                inventoryId = myOrderDetailDTO.getInventoryId();
//                inventoryIds.add(inventoryId); // 리스트에 inventoryId 추가

//                System.out.println(inventoryIds);

                // 인벤토리 ID 로 post 제목과 사진 들고오기 (JOIN 했음)
//                for (Integer inventoryId : inventoryIds) {
                    Inventory inventoryPS = inventoryRepository.findByIdWithPostTitleAndMainPhoto(inventoryId)
                            .orElseThrow(() -> new ExceptionApi404("인벤토리 정보를 찾을 수 없습니다. Inventory ID: " + inventoryId));
                    postTitle = inventoryPS.getProduct().getPost().getTitle();
                    postMainPhoto = inventoryPS.getProduct().getPost().getMainPhoto();
//
//                }

            }
        }

        return finalUserOrderDTO;
    }

    public UserResponse.UserReviewDTO 나의리뷰조회(User sessionUser) {
        User userPS = userRepository.findById(sessionUser.getId())
               .orElseThrow(() -> new ExceptionApi404("유저 정보를 찾을 수 없습니다."));

        return new UserResponse.UserReviewDTO(userPS);
    }

    public String 로그인(UserRequest.LoginDTO loginDTO) {
        User userPS = userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword())
                .orElseThrow(() -> new ExceptionApi401("아이뒤또는 이메일이 틀렸습니다."));

        String accessToken = JwtUtil.create(userPS);
        return accessToken;
    }
}
