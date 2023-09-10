package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.TimePeriod;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.TimePeriodMapper;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.TimePeriodDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.TimePeriodRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.TimePeriodService;
import org.springframework.stereotype.Service;

@Service
public class TimePeriodServiceImpl implements TimePeriodService {

    private final TimePeriodRepository repository;
    private final TimePeriodMapper mapper;

    public TimePeriodServiceImpl(TimePeriodRepository repository, TimePeriodMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TimePeriod createTimePeriod(TimePeriodDto timePeriodDto) {
        TimePeriod timePeriod = mapper.mapToTimePeriod(timePeriodDto);
        return repository.save(timePeriod);
    }

    @Override
    public void deleteTimePeriod(Long id) {

        {repository.deleteById(id);}
    }

}
