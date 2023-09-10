package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.entity.DaySchedule;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.DayScheduleDto;

import java.util.List;

public interface DayScheduleService {

    DaySchedule createDaySchedule(DayScheduleDto dayScheduleDto);

    void deleteDaySchedule(Long id);

    DaySchedule updateDaySchedule(DayScheduleDto dayScheduleDto);
    List<DayScheduleDto> getAllDaySchedulesByOfferId(Long id);

}
