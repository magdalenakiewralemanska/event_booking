package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OrderDto;

import java.util.List;

public interface OrderService {

    void createOrder(OrderDto orderDto);
    void deleteOrder(Long id) ;
    void updateOrder(Long id, OrderDto orderDto);
    List<OrderDto> getAllOrdersByUserId(Long id);
    OrderDto getOrderById(Long id);
}
