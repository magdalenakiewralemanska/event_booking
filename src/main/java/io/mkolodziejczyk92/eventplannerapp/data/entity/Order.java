package io.mkolodziejczyk92.eventplannerapp.data.entity;

import io.mkolodziejczyk92.eventplannerapp.data.enums.EStartingTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Column(name = "starting_time")
    @Enumerated(EnumType.STRING)
    private EStartingTime startingTime;

    @OneToMany(mappedBy = "order")
    private Set<Offer> offer;

    @OneToOne
    private OfferPackage offerPackage;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Customer customer;
}
