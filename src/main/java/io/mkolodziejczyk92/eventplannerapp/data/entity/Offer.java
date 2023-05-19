package io.mkolodziejczyk92.eventplannerapp.data.entity;

import io.mkolodziejczyk92.eventplannerapp.data.entity.user.Organizer;
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
@Table(name = "offers")
public class Offer extends AbstractEntity{

    private String name;

    @Column(name = "min_age")
    private int minAge;

    @Column(name = "max_age")
    private int maxAge;

    private String description;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "offer")
    private List<OfferPackage> offerPackages;

    @OneToMany(mappedBy = "offer")
    private List<WeekSchedule> availableDaysAndHours;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
