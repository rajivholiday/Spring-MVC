package com.example.pro5_6.exceptions;

public class NoSuchPhoneException extends RuntimeException{
    public NoSuchPhoneException(){
        super("No such phone found");
    }

}
