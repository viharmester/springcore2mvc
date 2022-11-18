package com.andorid.service;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;

import com.andorid.model.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.andorid.util.CsvReader;

@Component
public class EventStorageDAO {

    @Value("${app.external.data.path}")
    private String externalDataPath;

    @Value("${app.external.data.event.file.name}")
    private String eventData;

    @PostConstruct
    private void postConstruct() throws Exception {
        //eventRepository = CsvReader.readAllExample(externalDataPath, eventData, Event.class);
    }

    private List<Event> eventRepository = new LinkedList<>();

    public List<Event> getEventRepository() {
        return eventRepository;
    }

}
