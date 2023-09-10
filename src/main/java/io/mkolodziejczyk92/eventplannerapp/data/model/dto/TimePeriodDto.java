package io.mkolodziejczyk92.eventplannerapp.data.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimePeriodDto {

    private Long id;

    private LocalTime startHour;
    private LocalTime endHour;
    private Long dayScheduleId;
}
