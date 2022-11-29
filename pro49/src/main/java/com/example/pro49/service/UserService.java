package com.example.pro49.service;

import com.example.pro49.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserService {
    private final ArrayList<User> users = new ArrayList<User>();


    public void create(User user) {
        users.add(user);
    }

    public List<User> getAll() {
        return users;
    }
    public Optional<User> getById(int id){
        for(User u: users)
            if(u.getId() == id){
                return Optional.of(u);
            }
        return Optional.empty();
    }

    public Optional<User> getByEmail(String email) {
        for (User u : users)
            if (u.getEmail().equals(email)) {
                return Optional.of(u);
            }
        return Optional.empty();

    }

    public List<User> getByAge(int age) {
        List<User> sameAgeUsers = new ArrayList<>();
        for (User u : users)
            if (u.getAge() == age) {
                sameAgeUsers.add(u);
            }
        return sameAgeUsers;
    }

    public void update(int id, User user) {
        for (User u : users)
            if (u.getId() == id) {
                u.setName(user.getName());
                u.setSurname(user.getSurname());
                u.setAge(user.getAge());
                u.setEmail(user.getEmail());
            }
    }

    public void delete(int id) {
        for (User u : users)
            if (u.getId() == id) {
                users.remove(u);
                break;
            }

    }
}
