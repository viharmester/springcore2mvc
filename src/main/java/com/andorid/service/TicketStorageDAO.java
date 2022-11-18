package com.andorid.service;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;

import com.andorid.model.Ticket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.andorid.util.CsvReader;

@Component
public class TicketStorageDAO {

    @Value("${app.external.data.path}")
    private String externalDataPath;

    @Value("${app.external.data.ticket.file.name}")
    private String ticketData;

    @PostConstruct
    private void postConstruct() throws Exception {
        //ticketRepository = CsvReader.readAllExample(externalDataPath, ticketData, Ticket.class);
    }

    private List<Ticket> ticketRepository = new LinkedList<>();

    public List<Ticket> getTicketRepository() {
        return ticketRepository;
    }
}
