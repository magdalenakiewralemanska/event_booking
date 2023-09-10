package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.TimePeriod;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.TimePeriodDto;

import java.util.List;

public interface TimePeriodMapper {

    TimePeriodDto mapToTimePeriodDto(TimePeriod timePeriod);

    TimePeriod mapToTimePeriod(TimePeriodDto timePeriodDto);

}
