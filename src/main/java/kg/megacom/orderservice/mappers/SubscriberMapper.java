package kg.megacom.orderservice.mappers;

import kg.megacom.orderservice.mappers.impl.SubscriberMapperImpl;
import kg.megacom.orderservice.models.dto.SubscriberDto;
import kg.megacom.orderservice.models.entity.Subscriber;

public interface SubscriberMapper {
    SubscriberMapper INSTANCE = new SubscriberMapperImpl();

    Subscriber toEntity(SubscriberDto subscriberDto);

    SubscriberDto toDto(Subscriber subscriber);

}
