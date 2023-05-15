package io.mkolodziejczyk92.eventplannerapp.data.entity;

import io.mkolodziejczyk92.eventplannerapp.data.enums.EAddressType;
import io.mkolodziejczyk92.eventplannerapp.data.enums.ECountry;
import io.mkolodziejczyk92.eventplannerapp.data.enums.EVoivodeship;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "address")
public class Address extends AbstractEntity{

    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String zipCode;
    private String city;

    @Enumerated(EnumType.STRING)
    private ECountry country;

    @Enumerated(EnumType.STRING)
    private EVoivodeship voivodeship;

    @Enumerated(EnumType.STRING)
    private EAddressType addressType;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


}
