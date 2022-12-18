package kg.megacom.orderservice.services.impl;

import kg.megacom.orderservice.dao.SubscriberRepo;
import kg.megacom.orderservice.mappers.SubscriberMapper;
import kg.megacom.orderservice.models.dto.SubscriberDto;
import kg.megacom.orderservice.models.entity.Subscriber;
import kg.megacom.orderservice.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepo subscriberRepo;

    @Autowired
    private SubscriberMapper subscriberMapper;

    @Override
    public SubscriberDto save(SubscriberDto subscriberDto) {
        Subscriber subscriber = SubscriberMapper.INSTANCE.toEntity(subscriberDto);
        subscriber = subscriberRepo.save(subscriber);

        return SubscriberMapper.INSTANCE.toDto(subscriber);


    }

    @Override
    public List<SubscriberDto> findAll() {
        List<Subscriber> subscribers = subscriberRepo.findAll();
        List<SubscriberDto> subscriberDtos = subscribers
                .stream()
                .map(x -> subscriberMapper.toDto(x))
                .collect(Collectors.toList());
        return subscriberDtos;
    }

    @Override
    public SubscriberDto findSubsByPhone(String phone) {
        Subscriber subscriber = subscriberRepo.findByPhone(phone);
        return SubscriberMapper.INSTANCE.toDto(subscriber);
    }
}
