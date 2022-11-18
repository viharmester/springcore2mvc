package com.andorid.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.andorid.aspect.Loggable;
import com.andorid.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventStorageDAO storage;

    @Loggable
    public Optional<Event> getEventById(long eventId) {
        return storage.getEventRepository().stream()
            .filter(item -> item.getId() == eventId)
            .findFirst();
    }

    @Loggable
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        List<Event> events = storage.getEventRepository().stream()
            .filter(item -> item.getTitle().equals(title))
            .collect(Collectors.toList());

        return events.subList((pageSize - 1) * pageNum, Math.min(events.size(), pageSize));
    }

    @Loggable
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        List<Event> events = storage.getEventRepository().stream()
            .filter(item -> item.getDate().equals(day))
            .collect(Collectors.toList());

        return events.subList((pageSize - 1) * pageNum, Math.min(events.size(), pageSize));
    }

    @Loggable
    public Event createEvent(Event event) {
        storage.getEventRepository().add(event);
        return event;
    }

    @Loggable
    public Event updateEvent(Event event) {
        storage.getEventRepository().stream()
            .filter(item -> item.getId() == event.getId())
            .findFirst()
            .map(storage.getEventRepository()::remove);
        storage.getEventRepository().add(event);
        return event;
    }

    @Loggable
    public boolean deleteEvent(long eventId) {
        return storage.getEventRepository().stream()
            .filter(item -> item.getId() == eventId)
            .findFirst()
            .map(storage.getEventRepository()::remove)
            .orElse(false);
    }
}
