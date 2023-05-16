package io.mkolodziejczyk92.eventplannerapp.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "packages")
public class OfferPackage extends AbstractEntity{

    private String title;

    private String description;

    private double price;

    private int duration;

    @Column(name = "max_amount_of_people")
    private int maxAmountOfPeople;

    @Column(name = "is_Own_Food_Available")
    private boolean isOwnFoodAvailable;

    @Column(name = "is_Own_Drink_Available")
    private boolean isOwnDrinkAvailable;

    private String specials;

    @Column(name = "other_details")
    private String otherDetails;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

}
