package kg.megacom.orderservice.dao;

import kg.megacom.orderservice.models.entity.Order;
import kg.megacom.orderservice.models.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findTopBySubscriberOrderByIdDesc(Subscriber subscriber);

    Order findOrderAndEndDateIsNull(Order order);

}
