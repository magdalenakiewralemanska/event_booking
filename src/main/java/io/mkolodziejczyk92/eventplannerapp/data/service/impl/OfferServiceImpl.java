package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.entity.DaySchedule;
import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import io.mkolodziejczyk92.eventplannerapp.data.entity.TimePeriod;
import io.mkolodziejczyk92.eventplannerapp.data.enums.AddressType;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.OfferMapperImpl;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.DayScheduleDto;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OfferRepository;
import io.mkolodziejczyk92.eventplannerapp.data.repository.TimePeriodRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferMapperImpl offerMapper;
    private final OfferRepository repository;
    private final AddressService addressService;
    private final EventService eventService;

    private final TimePeriodService timePeriodService;

    private final DayScheduleService dayScheduleService;
    public OfferServiceImpl(OfferMapperImpl offerMapper, OfferRepository repository, AddressService addressService,
                            EventService eventService, TimePeriodService timePeriodService, DayScheduleService dayScheduleService) {
        this.offerMapper = offerMapper;
        this.repository = repository;
        this.addressService = addressService;
        this.eventService = eventService;
        this.timePeriodService = timePeriodService;
        this.dayScheduleService = dayScheduleService;
    }


    public void createOffer(OfferDto offerDto) {
        AddressDto addressDto = offerDto.getAddress();

        // Create the Address entity and save it
        Address address = addressService.saveAddress(addressDto);
        address.setAddressType(AddressType.EVENT_ADDRESS);

        // Create the Offer entity and set the Address
        Offer offer = offerMapper.mapToOffer(offerDto);
        address.setOffer(offer);
        offer.setAddress(address);


        List<DayScheduleDto> daySchedules = offerDto.getWeekSchedule();
        List<DaySchedule> savedDaySchedules = new ArrayList<>();

        for (DayScheduleDto dayScheduleDto : daySchedules) {
            DaySchedule daySchedule = dayScheduleService.createDaySchedule(dayScheduleDto);
            daySchedule.setOffer(offer);
            savedDaySchedules.add(daySchedule);
        }

        offer.setWeekSchedule(savedDaySchedules);

        repository.save(offer);
    }

    public void deleteOffer(Long id) {
        OfferDto offer = getOfferById(id);

        offer.getWeekSchedule().forEach(daySchedule -> {
            daySchedule.getWorkingHours().forEach(timePeriod -> timePeriodService.deleteTimePeriod(timePeriod.getId()));
            dayScheduleService.deleteDaySchedule(daySchedule.getId());
        });

        repository.deleteById(id);
        AddressDto address = offer.getAddress();
        addressService.deleteAddress(address.getId());
    }

    @Override
    public void updateOfferWithoutWeekSchedule(Long id, OfferDto offerDto){
        Optional<Offer> offerOptional = repository.findById(id);
        offerOptional.ifPresentOrElse(
                offer -> {
                    // Update offer properties
                    offer.setName(offerDto.getName());
                    offer.setMinAge(offerDto.getMinAge());
                    offer.setMaxAge(offerDto.getMaxAge());
                    offer.setDescription(offerDto.getDescription());
                    offer.setEvent(eventService.findEventById(offerDto.getEventId()));
                    offer.setOrganizer(offerDto.getOrganizer());
                    offer.setContactEmail(offerDto.getContactEmail());
                    offer.setContactPhone(offerDto.getContactPhone());
                    offer.setAddress(addressService.updateAddress(offerDto.getAddress()));
                    offer.setPicturePath(offerDto.getPicturePath());
                    repository.save(offer);
                },
                () -> {
                    throw new EntityNotFoundException("Entity id: " + id + " not found");
                }
        );
    }


    public void updateFullOffer(Long id, OfferDto offerDto) {
        Optional<Offer> offerOptional = repository.findById(id);
        offerOptional.ifPresentOrElse(
                offer -> {
                    // Update offer properties
                    offer.setName(offerDto.getName());
                    offer.setMinAge(offerDto.getMinAge());
                    offer.setMaxAge(offerDto.getMaxAge());
                    offer.setDescription(offerDto.getDescription());
                    offer.setEvent(eventService.findEventById(offerDto.getEventId()));
                    offer.setOrganizer(offerDto.getOrganizer());
                    offer.setContactEmail(offerDto.getContactEmail());
                    offer.setContactPhone(offerDto.getContactPhone());
                    offer.setPicturePath(offerDto.getPicturePath());
                    offer.setAddress(addressService.updateAddress(offerDto.getAddress()));

                    // Clear existing DaySchedule entities and their associated TimePeriod entities
                    for (DaySchedule daySchedule : offer.getWeekSchedule()) {
                        for (TimePeriod timePeriod:
                                daySchedule.getWorkingHours()) {
                            timePeriodService.deleteTimePeriod(timePeriod.getId());
                        }
                        dayScheduleService.deleteDaySchedule(daySchedule.getId());
                    }

                    // Create new DaySchedule entities and associate with the offer
                    for (DayScheduleDto dayScheduleDto : offerDto.getWeekSchedule()) {
                        DaySchedule daySchedule = dayScheduleService.createDaySchedule(dayScheduleDto);
                        daySchedule.setOffer(offer);
                        offer.getWeekSchedule().add(daySchedule);
                    }

                    repository.save(offer);
                },
                () -> {
                    throw new EntityNotFoundException("Entity id: " + id + " not found");
                }
        );
    }

    public List<OfferDto> getAllOffersByEventId(Long id) {
        List<Offer> offers = repository.findByEventId(id);
        return offerMapper.mapToOfferDtoList(offers);
    }

    public OfferDto getOfferById(Long id) {
        Offer offer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer does not exist"));
        return offerMapper.mapToOfferDto(offer);
    }

}
