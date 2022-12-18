package kg.megacom.orderservice.services.impl;

import kg.megacom.orderservice.dao.OrderRepo;
import kg.megacom.orderservice.mappers.OrderMapper;
import kg.megacom.orderservice.mappers.SubscriberMapper;
import kg.megacom.orderservice.enums.OrderStatus;
import kg.megacom.orderservice.models.dto.OrderDto;
import kg.megacom.orderservice.models.dto.OrderSubsDto;
import kg.megacom.orderservice.models.dto.SubscriberDto;
import kg.megacom.orderservice.models.entity.Order;
import kg.megacom.orderservice.models.responce.ResponseDto;
import kg.megacom.orderservice.services.OrderService;
import kg.megacom.orderservice.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseDto save(OrderSubsDto orderSubsDto) {
        ResponseDto responseDto = ResponseDto.getResponse();

        SubscriberDto subscriberDto = subscriberService.findSubsByPhone(orderSubsDto.getPhone());

        if (subscriberDto == null) {
            subscriberDto = new SubscriberDto();
            subscriberDto.setPhone(orderSubsDto.getPhone());
            subscriberDto = subscriberService.save(subscriberDto);
        } else {
            Order order = orderRepo.findTopBySubscriberOrderByIdDesc(SubscriberMapper.INSTANCE.toEntity(subscriberDto));
            OrderStatus orderStatus = orderService.findActualOrderStatus(order);
            if (orderStatus.equals(OrderStatus.PROCESSED)) {
                responseDto.setMessage("Ваш запрос обрабатывается");
                return responseDto;
            }
        }

        return responseDto;
    }

    @Override
    public OrderStatus findActualOrderStatus(Order order1) {
        Order order = orderRepo.findOrderAndEndDateIsNull(order1);
        return order.getOrderStatus();
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> subscribers = orderRepo.findAll();
        List<OrderDto> orderDtos = subscribers.stream().map(x -> orderMapper.toOrderDto(x)).collect(Collectors.toList());

        return orderDtos;
    }
}
