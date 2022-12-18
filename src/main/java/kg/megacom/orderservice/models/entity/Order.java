package kg.megacom.orderservice.models.entity;

import kg.megacom.orderservice.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String schoolName;
    private String address;
    private Date addDate;
    private Date endDate;
    private Date naviDate;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "id_subscriber")
    private Subscriber subscriber;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "order_status")
    private OrderStatus orderStatus;


}
