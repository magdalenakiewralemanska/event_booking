package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.TimePeriod;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.TimePeriodDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimePeriodMapperImpl implements TimePeriodMapper {

    @Override
    public TimePeriodDto mapToTimePeriodDto(TimePeriod timePeriod) {
        if (timePeriod == null) {
            return null;
        }

        TimePeriodDto timePeriodDto = new TimePeriodDto();

        timePeriodDto.setId(timePeriod.getId());
        timePeriodDto.setStartHour(timePeriod.getStartHour());
        timePeriodDto.setEndHour(timePeriod.getEndHour());
        timePeriodDto.setDayScheduleId(timePeriod.getDaySchedule().getId());

        return timePeriodDto;
    }

    @Override
    public TimePeriod mapToTimePeriod(TimePeriodDto timePeriodDto) {
        if (timePeriodDto == null) {
            return null;
        }

        TimePeriod timePeriod = new TimePeriod();

        timePeriod.setStartHour(timePeriodDto.getStartHour());
        timePeriod.setEndHour(timePeriodDto.getEndHour());

        return timePeriod;
    }

    @Override
    public List<TimePeriodDto> mapToTimePeriodDtoList(List<TimePeriod> timePeriods) {
        if (timePeriods == null) {
            return null;
        }

        List<TimePeriodDto> list = new ArrayList<>(timePeriods.size());
        for (TimePeriod timePeriod : timePeriods) {
            list.add(mapToTimePeriodDto(timePeriod));
        }

        return list;
    }
}
