package com.example.pro5_6.exceptions;

public class PhoneNotCreated extends RuntimeException {
    public PhoneNotCreated() {
        super("Phone not created");
    }
}
