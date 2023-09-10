package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Order;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OrderDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OfferPackageRepository;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OfferRepository;
import io.mkolodziejczyk92.eventplannerapp.data.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapperImpl implements OrderMapper{

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final OfferPackageRepository offerPackageRepository;
    private final OfferMapper offerMapper;
    private final OfferPackageMapper offerPackageMapper;

    public OrderMapperImpl(OfferRepository offerRepository, UserRepository userRepository, OfferPackageRepository offerPackageRepository,
                           OfferMapper offerMapper, OfferPackageMapper offerPackageMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.offerPackageRepository = offerPackageRepository;
        this.offerMapper = offerMapper;
        this.offerPackageMapper = offerPackageMapper;
    }

    @Override
    public OrderDto mapToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

       OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        orderDto.setDate( order.getDate() );
        orderDto.setOffer(offerMapper.mapToOfferDto(order.getOffer()));
        orderDto.setUserId(order.getUser().getId());
        orderDto.setOfferPackage(offerPackageMapper.mapToOfferPackageDto(order.getOfferPackage()));
        orderDto.setStartHour(order.getStartHour().toString());
        orderDto.setEndHour(order.getEndHour().toString());
        return orderDto;
    }

    @Override
    public Order mapToOrder(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }

        Order order = new Order();

        order.setDate(orderDto.getDate());
        String startHourString = orderDto.getStartHour();
        LocalTime startHour = LocalTime.parse(startHourString, DateTimeFormatter.ofPattern("H"));
        order.setStartHour(startHour);
        order.setOffer(offerRepository.findById(orderDto.getOffer().getId()).get());
        order.setUser(userRepository.findById(orderDto.getUserId()).get());
        order.setOfferPackage(offerPackageRepository.findById(orderDto.getOfferPackage().getId()).get());

        return order;
    }

    @Override
    public List<OrderDto> mapToOrderDtoList(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<>( orders.size() );
        for ( Order order : orders) {
            list.add( mapToOrderDto( order ) );
        }

        return list;
    }
}
