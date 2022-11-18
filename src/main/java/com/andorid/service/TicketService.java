package com.andorid.service;

import java.util.List;
import java.util.stream.Collectors;

import com.andorid.aspect.Loggable;
import com.andorid.dao.TicketImp;
import com.andorid.model.Event;
import com.andorid.model.Ticket;
import com.andorid.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketStorageDAO storage;

    @Loggable
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        TicketImp ticket = new TicketImp(storage.getTicketRepository().size() + 1, eventId, userId, category, place);
        storage.getTicketRepository().add(ticket);
        return ticket;
    }

    @Loggable
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        List<Ticket> tickets = storage.getTicketRepository().stream()
            .filter(item -> item.getUserId() == user.getId())
            .collect(Collectors.toList());

        return tickets.subList((pageSize - 1) * pageNum, Math.min(tickets.size(), pageSize));
    }

    @Loggable
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        List<Ticket> tickets = storage.getTicketRepository().stream()
            .filter(item -> item.getEventId() == event.getId())
            .collect(Collectors.toList());

        return tickets.subList((pageSize - 1) * pageNum, Math.min(tickets.size(), pageSize));
    }

    @Loggable
    public boolean cancelTicket(long ticketId) {
        return storage.getTicketRepository().stream()
            .filter(item -> item.getId() == ticketId)
            .findFirst()
            .map(storage.getTicketRepository()::remove)
            .orElse(false);
    }

}
