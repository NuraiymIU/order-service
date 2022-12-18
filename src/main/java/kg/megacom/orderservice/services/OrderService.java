package kg.megacom.orderservice.services;

import kg.megacom.orderservice.enums.OrderStatus;
import kg.megacom.orderservice.models.dto.OrderDto;
import kg.megacom.orderservice.models.dto.OrderSubsDto;
import kg.megacom.orderservice.models.entity.Order;
import kg.megacom.orderservice.models.responce.ResponseDto;

import java.util.List;

public interface OrderService {
    ResponseDto save(OrderSubsDto orderDto);

    OrderStatus findActualOrderStatus(Order order);

    List<OrderDto> findAll();
}
