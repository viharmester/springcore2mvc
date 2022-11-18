package com.andorid.service;

import java.util.Date;
import java.util.List;

import com.andorid.aspect.Loggable;
import com.andorid.facade.BookingFacade;
import com.andorid.model.Event;
import com.andorid.model.Ticket;
import com.andorid.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService implements BookingFacade {

    private final EventService eventService;
    private final TicketService ticketService;
    private final UserService userService;

    @Autowired
    public BookingService(EventService eventService, TicketService ticketService, UserService userService) {
        this.eventService = eventService;
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @Loggable
    @Override
    public Event getEventById(long eventId) {
        return eventService.getEventById(eventId).orElse(null);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventService.deleteEvent(eventId);
    }

    @Override
    public User getUserById(long userId) {
        return userService.getUserById(userId).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email).orElse(null);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userService.deleteUser(userId);
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketService.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketService.cancelTicket(ticketId);
    }
}
