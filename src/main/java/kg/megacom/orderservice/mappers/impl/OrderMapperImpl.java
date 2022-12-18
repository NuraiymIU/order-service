package kg.megacom.orderservice.mappers.impl;

import kg.megacom.orderservice.mappers.OrderMapper;
import kg.megacom.orderservice.mappers.SubscriberMapper;
import kg.megacom.orderservice.models.dto.OrderDto;
import kg.megacom.orderservice.models.entity.Order;
import kg.megacom.orderservice.models.entity.Subscriber;
import org.springframework.stereotype.Service;

@Service
public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order toOrder(OrderDto orderDto) {
        Order order = new Order();
        Subscriber subscriber = SubscriberMapper.INSTANCE.toEntity(orderDto.getSubscriber());
        if (orderDto.getId() != null) {
            order.setId(orderDto.getId());
        }
        order.setSubscriber(subscriber);
        order.setAddDate(orderDto.getAddDate());
        order.setAddress(orderDto.getAddress());
        order.setComment(orderDto.getComment());
        order.setEndDate(orderDto.getEndDate());
        order.setNaviDate(orderDto.getNaviDate());
        order.setSchoolName(orderDto.getSchoolName());
        return order;
    }

    @Override
    public OrderDto toOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();

        orderDto.setId(order.getId());
        orderDto.setAddDate(order.getAddDate());
        orderDto.setAddress(order.getAddress());
        orderDto.setEndDate(order.getEndDate());
        orderDto.setComment(order.getComment());
        orderDto.setNaviDate(order.getNaviDate());
        orderDto.setSchoolName(order.getSchoolName());
        orderDto.setSubscriber(SubscriberMapper.INSTANCE.toDto(order.getSubscriber()));
        return orderDto;
    }
}
