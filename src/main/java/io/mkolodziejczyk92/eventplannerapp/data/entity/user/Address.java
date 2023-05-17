package io.mkolodziejczyk92.eventplannerapp.data.entity.user;

import io.mkolodziejczyk92.eventplannerapp.data.entity.AbstractEntity;
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
public class Address extends AbstractEntity {

    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "apartment_number")
    private String apartmentNumber;

    @Column(name = "zip_code")
    private String zipCode;

    private String city;

    @Enumerated(EnumType.STRING)
    private ECountry country;

    @Enumerated(EnumType.STRING)
    private EVoivodeship voivodeship;

    @Enumerated(EnumType.STRING)
    private EAddressType addressType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
