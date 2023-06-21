package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferPackageDto;
import io.mkolodziejczyk92.eventplannerapp.data.service.OfferPackageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("offers/{offerId}/packages")
public class OfferPackageController {

    private final OfferPackageService packageService;

    public OfferPackageController(OfferPackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping()
    public List<OfferPackageDto> getPackages(@PathVariable Long offerId){
        return packageService.getAllOfferPackagesByOfferId(offerId);
    }

}
