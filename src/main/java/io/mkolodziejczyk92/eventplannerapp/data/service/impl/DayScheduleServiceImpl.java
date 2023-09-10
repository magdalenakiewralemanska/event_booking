package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.DaySchedule;
import io.mkolodziejczyk92.eventplannerapp.data.entity.TimePeriod;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.DayScheduleMapper;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.DayScheduleDto;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.TimePeriodDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.DayScheduleRepository;
import io.mkolodziejczyk92.eventplannerapp.data.repository.TimePeriodRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.DayScheduleService;
import io.mkolodziejczyk92.eventplannerapp.data.service.TimePeriodService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DayScheduleServiceImpl implements DayScheduleService {

    private final DayScheduleRepository repository;
    private final DayScheduleMapper mapper;

    private final TimePeriodService timePeriodService;

    public DayScheduleServiceImpl(DayScheduleRepository repository, DayScheduleMapper mapper, TimePeriodService timePeriodService) {
        this.repository = repository;
        this.mapper = mapper;
        this.timePeriodService = timePeriodService;
    }

    public DaySchedule createDaySchedule(DayScheduleDto dayScheduleDto) {
        DaySchedule daySchedule = mapper.mapToDaySchedule(dayScheduleDto);
        List<TimePeriod> timePeriods = new ArrayList<>();
        for (TimePeriodDto timePeriodDto:
                dayScheduleDto.getWorkingHours()) {
            TimePeriod timePeriod = timePeriodService.createTimePeriod(timePeriodDto);
            timePeriods.add(timePeriod);
        }
        repository.save(daySchedule);
        for (TimePeriod tp: timePeriods) {
            tp.setDaySchedule(daySchedule);
        }
        return daySchedule;
    }

    public void deleteDaySchedule(Long id) {
        repository.deleteById(id);
    }
    @Transactional
    public DaySchedule updateDaySchedule(DayScheduleDto dayScheduleDto) {
        List<DaySchedule> weekSchedule = repository.findByOfferId(dayScheduleDto.getOfferId());
        for (DaySchedule daySchedule : weekSchedule) {
            if (!daySchedule.getWorkingHours().isEmpty()) {
                deleteDaySchedule(daySchedule.getId());
            } else {
                repository.deleteById(daySchedule.getId());
            }

        }return createDaySchedule(dayScheduleDto);
    }

    public DayScheduleDto getDayScheduleById(Long id) {
        DaySchedule daySchedule = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Day schedule does not exist"));
        return mapper.mapToDayScheduleDto(daySchedule);
    }

    public List<DayScheduleDto> getAllDaySchedulesByOfferId(Long id) {
        List<DaySchedule> daySchedules = repository.findByOfferId(id);
        return mapper.mapToDayScheduleDtoList(daySchedules);
    }
}
