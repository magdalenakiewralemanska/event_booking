package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Order;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.OrderMapper;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OrderDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OfferPackageRepository;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OrderRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository repository;
    private final OfferPackageRepository packageRepository;

    public OrderServiceImpl(OrderMapper orderMapper, OrderRepository repository, OfferPackageRepository packageRepository) {
        this.orderMapper = orderMapper;
        this.repository = repository;
        this.packageRepository = packageRepository;
    }

    @Override
    public void createOrder(OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        order.setEndHour(order.getStartHour().plusHours(order.getOfferPackage().getDuration()));
        repository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateOrder(Long id, OrderDto orderDto) {
        Optional<Order> orderOptional = repository.findById(id);
        orderOptional.ifPresentOrElse(order -> {
            order.setDate(orderDto.getDate());
            order.setStartHour(LocalTime.parse(orderDto.getStartHour()));
            order.setOfferPackage(packageRepository.findById(orderDto.getOfferPackage().getId()).get());
        }, () -> {
            throw new EntityNotFoundException("Entity id: " + id + " not found");
        });
    }

    @Override
    public List<OrderDto> getAllOrdersByUserId(Long userId) {
        List<Order> orders = repository.findByUserId(userId);
        return orderMapper.mapToOrderDtoList(orders);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order does not exist"));
        return orderMapper.mapToOrderDto(order);
    }
}
