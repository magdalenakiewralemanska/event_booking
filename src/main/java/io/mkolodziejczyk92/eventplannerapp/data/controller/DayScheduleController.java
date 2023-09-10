package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.DayScheduleDto;
import io.mkolodziejczyk92.eventplannerapp.data.service.DayScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daySchedule/{offerId}")
public class DayScheduleController {
    private final DayScheduleService dayScheduleService;

    public DayScheduleController(DayScheduleService dayScheduleService) {
        this.dayScheduleService = dayScheduleService;
    }

    @GetMapping()
    public List<DayScheduleDto> getDaySchedules(@PathVariable Long offerId){
        return dayScheduleService.getAllDaySchedulesByOfferId(offerId);
    }

    @PostMapping("/addDaySchedule")
    public void createDaySchedule(@RequestBody DayScheduleDto dayScheduleDto){
        dayScheduleService.createDaySchedule(dayScheduleDto);
    }

    @PutMapping("/updateDaySchedule")
    public void updateDaySchedule(@RequestBody DayScheduleDto dayScheduleDto){
        dayScheduleService.updateDaySchedule(dayScheduleDto);
    }

    @DeleteMapping("{dayScheduleId}")
    public void deleteDaySchedule(@PathVariable Long dayScheduleId){
        dayScheduleService.deleteDaySchedule(dayScheduleId);
    }

}
