package shop.mtcoding.todayhome.order;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.cart.Cart;
import shop.mtcoding.todayhome.cart.CartRepository;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;
import shop.mtcoding.todayhome.inventory.Inventory;
import shop.mtcoding.todayhome.inventory.InventoryRepository;
import shop.mtcoding.todayhome.orderdetail.OrderDetail;
import shop.mtcoding.todayhome.orderdetail.OrderDetailRepository;
import shop.mtcoding.todayhome.ready.Ready;
import shop.mtcoding.todayhome.ready.ReadyRepository;
import shop.mtcoding.todayhome.user.User;
import shop.mtcoding.todayhome.user.UserRepository;

import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    // 장바구니에서 주문서로 넘기기
    @Transactional
    public OrderResponse.DTO insertOrder(User sessionUser,List<OrderRequest.CartDTO> cartDTOList ) {

        // 0. cart의 id를 통해 데이터 찾기
        /*List<Integer> cartDTOList = cartListDTO.getCarts().stream()
                .map(OrderRequest.CartDTO::getId)
                .collect(Collectors.toList());*/
        List<Integer> cartIds = cartDTOList.stream()
                .map(OrderRequest.CartDTO::getId)
                .collect(Collectors.toList());
        System.out.println(cartIds);
        List<Cart> cartList = cartRepository.findAllById(cartIds);

        // List<Cart> cartList = cartRepository.findCountAndPriceByIds(cartIds);
        int quantity = 0;       // 주문번호에 들어갈 총 수량
        int totalAmount = 0;    // 주문번호에 들어갈 총 가격

        // 장바구니 삭제용 id 리스트
        List<Integer> cartDeleteIds = new ArrayList<>();
        for (Cart cart : cartList) {
            int count = (int) cart.getCount();
            int price = (int) cart.getPrice();
            quantity += count;
            totalAmount += price;
            cartDeleteIds.add(cart.getId());
        }

        // 1. order 테이블 생성 후 orderID 추출
        String partnerOrderId = UUID.randomUUID().toString();   // 주문번호 생성

        User userPS = userRepository.findById(sessionUser.getId()).orElseThrow(
                () -> new ExceptionApi404("유저를 찾을 수 없어요.")
        );
        OrderRequest.SaveOrderDTO saveOrderDTO = new OrderRequest.SaveOrderDTO();
        Order orderEntity = saveOrderDTO.toEntity(partnerOrderId, userPS, totalAmount, quantity);
        Order order = orderRepository.save(orderEntity);

        // 2. orderID를 가지고 orderDetail 생성
        List<OrderDetail> ds = new ArrayList<>();

        for (Cart cart : cartList) {
            // (1) inventory 들고오기
            Inventory inventory = inventoryRepository.findById(cart.getInventory().getId())
                    .orElseThrow(() -> new ExceptionApi404("상품이 존재하지 않습니다(inventory)"));

            OrderRequest.SaveOrderDetailDTO saveOrderDetailDTO = new OrderRequest.SaveOrderDetailDTO();

            OrderDetail orderDetail1 = saveOrderDetailDTO.toEntity(order, inventory, cart);
            ds.add(orderDetail1);

        }
        orderDetailRepository.saveAll(ds); // 벌크
        cartRepository.deleteAllById(cartDeleteIds); // 벌크

        // 3. 주문 내역에 들어간 내용들 담아서 뿌리기
        List<OrderResponse.OrderDetailDTO> orderDetailDTOList = orderRepository.mfindOrderdetailDTO(partnerOrderId);
        OrderResponse.OrderDTO orderDTO = orderRepository.mfindOrderDTO(partnerOrderId);

        return new OrderResponse.DTO(orderDTO, orderDetailDTOList);
    }




}
