package kg.megacom.orderservice.services;

import kg.megacom.orderservice.models.dto.SubscriberDto;
import kg.megacom.orderservice.models.entity.Subscriber;

import java.util.List;

public interface SubscriberService {
    SubscriberDto save(SubscriberDto subscriberDto);

    List<SubscriberDto> findAll();

    SubscriberDto findSubsByPhone(String phone);
}
