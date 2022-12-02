package com.example.pro4_10.service;

import com.example.pro4_10.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserService {
    private final ArrayList<User> users = new ArrayList<>();

    public void create(User user) {
        users.add(user);
        log.info("User was created");
    }

    public List<User> getAll() {
        log.info("Getting the list of users");
        return users;
    }

    public Optional<User> getById(int id) {
        log.info("Getting user with  id number");
        for (User u : users)
            if (u.getId() == id) {
                return Optional.of(u);
            }
        return Optional.empty();
    }

    public Optional<User> getByName(String name) {
        log.info("Getting user with the name");
        for (User u : users)
            if (u.getName().equals(name)) {
                return Optional.of(u);
            }
        return Optional.empty();
    }

    public void update(int id, User user) {
        for (User u : users)
            if (u.getId() == id) {
                u.setName(user.getName());
                u.setSurname(user.getSurname());
                u.setOccupation(user.getOccupation());
                u.setMaritalStatus(user.getMaritalStatus());
                u.setAge(user.getAge());
            }
        log.info("User was updated");
    }

    public void delete(int id) {
        for (User u : users)
            if (u.getId() == id) {
                users.remove(u);
                break;
            }
        log.info("User was deleted");
    }
}
