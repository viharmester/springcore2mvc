package com.andorid.service;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.andorid.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.andorid.util.CsvReader;

@Component
public class UserStorageDAO {

    @Value("${app.external.data.path}")
    private String externalDataPath;

    @Value("${app.external.data.user.file.name}")
    private String userData;

    @PostConstruct
    private void postConstruct() throws Exception {
        //userRepository = CsvReader.readAllExample(externalDataPath, userData, User.class);
    }

    private List<User> userRepository = new LinkedList<>();
    public List<User> getUserRepository() {
        return userRepository;
    }
}
