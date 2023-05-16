package io.mkolodziejczyk92.eventplannerapp.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Break extends AbstractEntity{

    private LocalTime start;

    private LocalTime end;

    @ManyToOne
    @JoinColumn(name = "day_schedule_id")
    private DaySchedule daySchedule;
}
