package com.example.pro5_3.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound() {
        super("No such user found");
    }
}
