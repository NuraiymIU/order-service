package kg.megacom.orderservice.controllers;

import kg.megacom.orderservice.models.dto.SubscriberDto;
import kg.megacom.orderservice.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscriber")
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping("/save")
    public SubscriberDto save(@RequestBody SubscriberDto subscriberDto) {
        return subscriberService.save(subscriberDto);
    }

    @GetMapping("/all")
    public List<SubscriberDto> findAll() {
        return subscriberService.findAll();
    }

}
