package kg.megacom.orderservice.mappers.impl;

import kg.megacom.orderservice.mappers.SubscriberMapper;
import kg.megacom.orderservice.models.dto.SubscriberDto;
import kg.megacom.orderservice.models.entity.Subscriber;
import org.springframework.stereotype.Service;

@Service
public class SubscriberMapperImpl implements SubscriberMapper {
    @Override
    public Subscriber toEntity(SubscriberDto subscriberDto) {
        Subscriber subscriber = new Subscriber();

        if (subscriberDto.getId() != null) {
            subscriber.setId(subscriberDto.getId());
        }
        subscriber.setName(subscriberDto.getName());
        subscriber.setDateOfBirth(subscriberDto.getDateOfBirth());
        subscriber.setPhone(subscriberDto.getPhone());
        subscriber.setAge(subscriberDto.getAge());

        return subscriber;
    }

    @Override
    public SubscriberDto toDto(Subscriber subscriber) {

        SubscriberDto subscriberDto = new SubscriberDto();
        subscriberDto.setId(subscriber.getId());
        subscriberDto.setName(subscriber.getName());
        subscriberDto.setDateOfBirth(subscriber.getDateOfBirth());
        subscriberDto.setPhone(subscriber.getPhone());
        subscriberDto.setAge(subscriber.getAge());

        return subscriberDto;
    }
}
