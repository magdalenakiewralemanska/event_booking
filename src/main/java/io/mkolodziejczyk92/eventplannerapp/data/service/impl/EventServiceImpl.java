package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Event;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.EventMapper;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.EventDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.EventRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.EventService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository repository;
    private final EventMapper eventMapper;

    public EventServiceImpl(EventRepository repository, EventMapper eventMapper) {
        this.repository = repository;
        this.eventMapper = eventMapper;
    }

    public EventDto createEvent(EventDto eventDto) {
        Event event = eventMapper.mapToEvent(eventDto);
        repository.save(event);
        return eventMapper.mapToEventDto(event);
    }

    public void deleteEvent(EventDto eventDto) {
        Long id = eventDto.getId();
        repository.deleteById(id);
    }

    public void updateEvent(EventDto eventDto) {
        Long id = eventDto.getId();
        Optional<Event> eventOptional = repository.findById(id);
        eventOptional.ifPresentOrElse(event -> {
            event.setName(eventDto.getName());
            event.setPicturePath(eventDto.getPicturePath());
            repository.save(event);
        }, () -> {
            throw new EntityNotFoundException("Entity id: " + id + " not found");
        });
    }

    public List<EventDto> getAllEvents() {
        return eventMapper.mapToEventDtoList(repository.findAll());
    }

    @Override
    public Event findEventById(Long id) {
        Optional<Event> eventOptional = repository.findById(id);
        return eventOptional.orElseThrow(() -> new EntityNotFoundException("Event not found"));
    }
}
