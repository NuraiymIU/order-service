package kg.megacom.orderservice.mappers;

import kg.megacom.orderservice.mappers.impl.OrderMapperImpl;
import kg.megacom.orderservice.models.dto.OrderDto;
import kg.megacom.orderservice.models.entity.Order;

public interface OrderMapper {
    OrderMapper INSTANCE = new OrderMapperImpl();

    Order toOrder(OrderDto orderDto);

    OrderDto toOrderDto(Order order);


}
