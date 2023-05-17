package io.mkolodziejczyk92.eventplannerapp.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "day_schedules")
public class DaySchedule extends AbstractEntity{

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Column(name = "start_working_hour")
    private LocalTime startHour;

    @Column(name = "end_working_hour")
    private LocalTime endHour;

    @ManyToOne
    @JoinColumn(name = "weekSchedule_id")
    WeekSchedule weekSchedule;

    @OneToMany(mappedBy = "daySchedule")
    private List<Break> breaks;

}
