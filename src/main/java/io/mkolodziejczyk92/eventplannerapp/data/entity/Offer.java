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
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 10000)
    private String description;
    private String organizer;
    private String contactEmail;
    private String contactPhone;

    @Column(name = "min_age")
    private int minAge;

    @Column(name = "max_age")
    private int maxAge;

    @Column(name = "picture_path", columnDefinition = "BLOB")
    private String picturePath;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "offer")
    private List<OfferPackage> offerPackages;

    @OneToOne()
    private Address address;

    @OneToMany(mappedBy = "offer")
    private List<DaySchedule> weekSchedule;

    @OneToMany(mappedBy = "offer")
    private List<Order> orders;

}
