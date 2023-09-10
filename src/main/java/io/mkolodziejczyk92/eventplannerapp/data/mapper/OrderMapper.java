package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Order;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OrderDto;

import java.util.List;

public interface OrderMapper {

    OrderDto mapToOrderDto(Order order);

    Order mapToOrder(OrderDto orderDto);

    List<OrderDto> mapToOrderDtoList(List<Order> orders);
}
