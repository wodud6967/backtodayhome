package shop.mtcoding.todayhome.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;
import shop.mtcoding.todayhome.inventory.Inventory;
import shop.mtcoding.todayhome.inventory.InventoryRepository;
import shop.mtcoding.todayhome.user.User;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final InventoryRepository inventoryRepository;

    // 유저ID로 장바구니 조회하기
    @Transactional
    public List<CartResponse.DTO> selectCart(int id) {

        try {
            List<CartResponse.DTO> cartList = cartRepository.findByUserId(id);
            return cartList;
        } catch (Exception e) {
            throw new ExceptionApi404("장바구니가 존재하지 않습니다");
        }

    }

    @Transactional
    public List<CartResponse.DTO> insertCart(User user, CartRequest.DTO cartRequest) {

        int count = 1;
        int inventoryId = cartRequest.getInventoryId();
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new ExceptionApi404("상품이 존재하지 않습니다(inventory)"));
        int price = cartRequest.getPrice();
        int totalPrice = cartRequest.getTotalPrice();
        CartRequest.SaveCartDTO saveCartDTO = new CartRequest.SaveCartDTO();
        Cart cart = saveCartDTO.toEntity(user, inventory, count, price, totalPrice);
        cartRepository.save(cart);

        int id = user.getId();
        try {
            List<CartResponse.DTO> cartList = cartRepository.findByUserId(id);
            return cartList;
        } catch (Exception e) {
            throw new ExceptionApi404("장바구니가 존재하지 않습니다");
        }
    }

}
