package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.DaySchedule;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.DayScheduleDto;

import java.util.List;

public interface DayScheduleMapper {

    DayScheduleDto mapToDayScheduleDto(DaySchedule daySchedule);

    DaySchedule mapToDaySchedule(DayScheduleDto dayScheduleDto);

    List<DayScheduleDto> mapToDayScheduleDtoList(List<DaySchedule> daySchedules);
}
