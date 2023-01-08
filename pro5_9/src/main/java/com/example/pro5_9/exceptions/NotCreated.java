package com.example.pro5_9.exceptions;

public class NotCreated extends RuntimeException{
    public NotCreated(){
        super("No such entity crated");
    }
}
