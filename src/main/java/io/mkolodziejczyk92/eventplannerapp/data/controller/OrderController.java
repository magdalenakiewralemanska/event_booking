package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OrderDto;
import io.mkolodziejczyk92.eventplannerapp.data.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list/{userId}")
    public List<OrderDto> getOrders(@PathVariable Long userId){
        return orderService.getAllOrdersByUserId(userId);
    }

    @GetMapping("/{orderId}")
    public OrderDto getOrderById(@PathVariable Long orderId){
        return orderService.getOrderById(orderId);
    }

    @PostMapping("/addOrder")
    public void createOrder(@RequestBody OrderDto orderDto){
        orderService.createOrder(orderDto);
    }

    @PutMapping("/{orderId}")
    public void updateOrder(@RequestBody OrderDto orderDto, @PathVariable Long orderId){
        orderService.updateOrder(orderId, orderDto);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
    }
}
