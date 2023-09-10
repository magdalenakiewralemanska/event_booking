package io.mkolodziejczyk92.eventplannerapp.data.repository;

import io.mkolodziejczyk92.eventplannerapp.data.entity.DaySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayScheduleRepository extends JpaRepository<DaySchedule, Long> {

    List<DaySchedule> findByOfferId(Long offerId);
}
