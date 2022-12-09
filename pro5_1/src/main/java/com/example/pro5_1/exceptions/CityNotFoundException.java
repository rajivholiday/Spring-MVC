package com.example.pro5_1.exceptions;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException() {
        super("No such city found");
    }
}
