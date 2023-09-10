package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.entity.TimePeriod;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.TimePeriodDto;

public interface TimePeriodService {

    TimePeriod createTimePeriod(TimePeriodDto newTimePeriodDto);

    void deleteTimePeriod(Long id);

}
