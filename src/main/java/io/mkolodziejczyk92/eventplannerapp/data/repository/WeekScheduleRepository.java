package io.mkolodziejczyk92.eventplannerapp.data.repository;

import io.mkolodziejczyk92.eventplannerapp.data.entity.WeekSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekScheduleRepository extends JpaRepository<WeekSchedule, Long> {
}
