package io.mkolodziejczyk92.eventplannerapp.data.repository;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
