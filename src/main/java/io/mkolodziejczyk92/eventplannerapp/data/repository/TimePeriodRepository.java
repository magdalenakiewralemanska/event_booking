package io.mkolodziejczyk92.eventplannerapp.data.repository;

import io.mkolodziejczyk92.eventplannerapp.data.entity.DaySchedule;
import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import io.mkolodziejczyk92.eventplannerapp.data.entity.TimePeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimePeriodRepository extends JpaRepository<TimePeriod, Long> {
    void deleteByDayScheduleOffer(Offer offer);

    void deleteByDaySchedule(DaySchedule daySchedule);
}
