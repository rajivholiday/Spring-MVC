package com.example.pro5_9.exceptions;

public class NotFoundException  extends RuntimeException{
    public NotFoundException(){
        super("No such entity found");
    }
}
