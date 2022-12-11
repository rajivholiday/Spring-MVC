package com.example.pro5_1.exceptions;

public class UserNotCreatedException extends  RuntimeException{
    public UserNotCreatedException(){
        super("No such city created");

    }
}
