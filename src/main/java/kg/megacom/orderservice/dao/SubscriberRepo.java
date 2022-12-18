package kg.megacom.orderservice.dao;

import kg.megacom.orderservice.models.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepo extends JpaRepository<Subscriber, Long> {

    Subscriber findByPhone(String phone);
}
