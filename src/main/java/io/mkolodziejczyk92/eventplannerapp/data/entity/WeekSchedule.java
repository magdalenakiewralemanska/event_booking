package io.mkolodziejczyk92.eventplannerapp.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "week_schedules")
public class WeekSchedule extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "id_offer")
    private Offer offer;

    @OneToMany(mappedBy = "weekSchedule")
    private List<DaySchedule> weekDay;

}
