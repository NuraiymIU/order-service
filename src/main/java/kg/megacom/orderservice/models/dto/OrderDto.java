package kg.megacom.orderservice.models.dto;

import kg.megacom.orderservice.enums.OrderStatus;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {

    private Long id;
    private String schoolName;
    private String address;
    private Date addDate;
    private Date endDate;
    private Date naviDate;
    private String comment;
    private SubscriberDto subscriber;
    private OrderStatus orderStatus;

}
