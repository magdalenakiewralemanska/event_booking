package io.mkolodziejczyk92.eventplannerapp.data.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private Long userId;
    private OfferPackageDto offerPackage;
    private OfferDto offer;
    private Date date;

    private String startHour;
    private String endHour;
}
