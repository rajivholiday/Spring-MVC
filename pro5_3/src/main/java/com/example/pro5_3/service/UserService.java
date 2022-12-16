package com.example.pro5_3.service;

import com.example.pro5_3.entity.User;
import com.example.pro5_3.exception.UserNotFound;
import com.example.pro5_3.repository.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserService {
    private final UserRepo repo;


    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public void create_User(User user) {
        repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getUserById(int id) {
        log.info("User with id - {} was retrieved", id);
        return repo.findById(id);
    }

    public void updateUserById(User user) {
        User user_from_db = getUserById(user.getId()).orElseThrow(UserNotFound::new);
        user_from_db.setName(user.getName());
        user_from_db.setSurname(user.getSurname());
        user_from_db.setAge(user.getId());
        user_from_db.setPostalCode(user.getPostalCode());
        log.info("user with id - {} was updated", getUserById(user.getId()));
    }

    public void deleteUserById(int id) {
        repo.deleteById(id);
        log.info("User with id - {} was deleted", id);

    }
}
