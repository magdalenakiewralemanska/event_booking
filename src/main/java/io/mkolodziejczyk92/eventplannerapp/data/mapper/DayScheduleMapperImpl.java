package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.DaySchedule;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.DayScheduleDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OfferRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DayScheduleMapperImpl implements DayScheduleMapper{

    private final TimePeriodMapper timePeriodMapper;

    public DayScheduleMapperImpl(TimePeriodMapper timePeriodMapper) {
        this.timePeriodMapper = timePeriodMapper;
    }

    @Override
    public DayScheduleDto mapToDayScheduleDto(DaySchedule daySchedule) {
        if ( daySchedule == null ) {
            return null;
        }

        DayScheduleDto dayScheduleDto = new DayScheduleDto();

        dayScheduleDto.setId( daySchedule.getId() );
        dayScheduleDto.setDate( daySchedule.getDate() );
        dayScheduleDto.setWorkingHours(daySchedule
                .getWorkingHours()
                .stream()
                .map(timePeriodMapper::mapToTimePeriodDto)
                .collect(Collectors.toList()));
        dayScheduleDto.setOfferId(daySchedule.getOffer().getId());
        return dayScheduleDto;
    }

    @Override
    public DaySchedule mapToDaySchedule(DayScheduleDto dayScheduleDto) {
        if ( dayScheduleDto == null ) {
            return null;
        }

        DaySchedule daySchedule = new DaySchedule();

        daySchedule.setDate( dayScheduleDto.getDate() );
        daySchedule.setWorkingHours(dayScheduleDto
                .getWorkingHours()
                .stream()
                .map(timePeriodMapper::mapToTimePeriod)
                .collect(Collectors.toList()));
        return daySchedule;
    }

    @Override
    public List<DayScheduleDto> mapToDayScheduleDtoList(List<DaySchedule> daySchedules) {
        if ( daySchedules == null ) {
            return null;
        }

        List<DayScheduleDto> list = new ArrayList<>( daySchedules.size() );
        for ( DaySchedule daySchedule : daySchedules ) {
            list.add( mapToDayScheduleDto( daySchedule ) );
        }

        return list;
    }
}
