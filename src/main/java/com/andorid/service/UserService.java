package com.andorid.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.andorid.aspect.Loggable;
import com.andorid.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserStorageDAO storage;

    @Loggable
    public Optional<User> getUserById(long userId) {
        return storage.getUserRepository().stream()
            .filter(item -> item.getId() == userId)
            .findFirst();
    }

    @Loggable
    public Optional<User> getUserByEmail(String email) {
        return storage.getUserRepository().stream()
            .filter(item -> item.getEmail().equals(email))
            .findFirst();
    }

    @Loggable
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        List<User> users = storage.getUserRepository().stream()
            .filter(item -> item.getName().equals(name))
            .collect(Collectors.toList());

        return users.subList((pageSize - 1) * pageNum, Math.min(users.size(), pageSize));
    }

    @Loggable
    public User createUser(User user) {
        storage.getUserRepository().add(user);
        return user;
    }

    @Loggable
    public User updateUser(User user) {
        storage.getUserRepository().stream()
            .filter(item -> item.getId() == user.getId())
            .findFirst()
            .map(storage.getUserRepository()::remove);
        storage.getUserRepository().add(user);
        return user;
    }

    @Loggable
    public boolean deleteUser(long userId) {
        return storage.getUserRepository().stream()
            .filter(item -> item.getId() == userId)
            .findFirst()
            .map(storage.getUserRepository()::remove)
            .orElse(false);
    }
}
