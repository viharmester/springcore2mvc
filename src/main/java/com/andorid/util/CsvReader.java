package com.andorid.util;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.andorid.dao.EventImp;
import com.andorid.dao.TicketImp;
import com.andorid.dao.UserImp;
import com.andorid.model.Ticket;
import com.opencsv.CSVReader;
import com.andorid.model.Event;
import com.andorid.model.User;

public class CsvReader {

    public static <T> List<T> readAllExample(String externalDataPath, String externalDataFileName, Class<T> clazz) throws Exception {
        Path path = Paths.get(ClassLoader.getSystemResource(externalDataPath + "/" + externalDataFileName + ".csv").toURI());
        List<String[]> strings = readAllLines(path);

        switch (clazz.getTypeName()) {
            case "model.User": {
                return (List<T>) strings.stream()
                    .map(CsvReader::createUser)
                    .collect(Collectors.toList());
            }
            case "model.Ticket": {
                return (List<T>) strings.stream()
                    .map(CsvReader::createTicket)
                    .collect(Collectors.toList());
            }
            case "model.Event": {
                return (List<T>) strings.stream()
                    .map(CsvReader::createEvent)
                    .collect(Collectors.toList());
            }
            default:
                return null;
        }
    }

    private static List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }

    private static User createUser(String[] metadata) {
        long id = Long.parseLong(metadata[0]);
        String name = metadata[1];
        String email = metadata[2];
        return null;// new UserImp(id, name, email);
    }

    private static Ticket createTicket(String[] metadata) {
        long id = Long.parseLong(metadata[0]);
        long eventId = Long.parseLong(metadata[1]);
        long userId = Long.parseLong(metadata[2]);
        Ticket.Category category = Ticket.Category.valueOf(metadata[3]);
        int place = Integer.parseInt(metadata[4]);
        return null;// new TicketImp(id, eventId, userId, category, place);
    }

    private static Event createEvent(String[] metadata) {
        long id = Long.parseLong(metadata[0]);
        String title = metadata[1];
        Date date = Date.valueOf(metadata[2]);
        return null;// new EventImp(id, title, date);
    }

}


