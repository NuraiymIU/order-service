package kg.megacom.orderservice.controllers;

import kg.megacom.orderservice.models.dto.OrderDto;
import kg.megacom.orderservice.models.dto.OrderSubsDto;
import kg.megacom.orderservice.models.responce.ResponseDto;
import kg.megacom.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseDto save(@RequestBody OrderSubsDto orderDto) {
        return orderService.save(orderDto);
    }

    @GetMapping("/allList")
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }
}
