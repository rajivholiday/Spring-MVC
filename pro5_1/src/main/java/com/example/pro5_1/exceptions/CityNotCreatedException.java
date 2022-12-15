package com.example.pro5_1.exceptions;

public class CityNotCreatedException extends  RuntimeException{
    public CityNotCreatedException(){
        super("No such city created");

    }
}
