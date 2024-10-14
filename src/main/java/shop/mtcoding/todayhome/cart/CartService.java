package shop.mtcoding.todayhome.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;

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

}
