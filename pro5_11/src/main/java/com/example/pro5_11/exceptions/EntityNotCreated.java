package com.example.pro5_11.exceptions;

public class EntityNotCreated extends RuntimeException{
    public EntityNotCreated(){
        super("Entity not created");
    }
}
