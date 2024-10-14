package shop.mtcoding.todayhome.order;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi404;
import shop.mtcoding.todayhome.inventory.Inventory;
import shop.mtcoding.todayhome.inventory.InventoryRepository;
import shop.mtcoding.todayhome.orderdetail.OrderDetail;
import shop.mtcoding.todayhome.orderdetail.OrderDetailRepository;
import shop.mtcoding.todayhome.ready.Ready;
import shop.mtcoding.todayhome.ready.ReadyRepository;
import shop.mtcoding.todayhome.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;
    private final OrderDetailRepository orderDetailRepository;

    // 장바구니에서 주문서로 넘기기
    @Transactional
    public OrderResponse.DTO insertOrder(User sessionUser, OrderRequest.DTO orderRequest) {

        // 1. order 테이블 생성 후 orderID 추출
        String partnerOrderId = UUID.randomUUID().toString();
        int totalAmount = orderRequest.getTotalAmount();
        int quantity = orderRequest.getQuantity();
        OrderRequest.SaveOrderDTO saveOrderDTO = new OrderRequest.SaveOrderDTO();
        Order orderEntity = saveOrderDTO.toEntity(partnerOrderId,sessionUser,totalAmount,quantity);
        orderRepository.save(orderEntity);

        Order order = orderRepository.mfindByPartnerOrderId(partnerOrderId);

        // 2. orderID를 가지고 orderDetail 생성

        List<OrderRequest.OrderDetailDTO> orderDetails = orderRequest.getDetails();

        for (OrderRequest.OrderDetailDTO orderDetail : orderDetails){

            OrderRequest.SaveOrderDetailDTO saveOrderDetailDTO = new OrderRequest.SaveOrderDetailDTO();

            int inventoryId = orderDetail.getInventoryId();
            Inventory inventory = inventoryRepository.findById(inventoryId)
                    .orElseThrow(() -> new ExceptionApi404("상품이 존재하지 않습니다(inventory)"));

                OrderDetail orderDetail1 = saveOrderDetailDTO.toEntity(order,inventory, orderDetail);
                orderDetailRepository.save(orderDetail1);
        }

        // 3. 주문 내역에 들어간 내용들 담아서 뿌리기
        OrderResponse.DTO orderPage = orderRepository.mfindOrderPage(partnerOrderId);

        return orderPage;
    }


}
