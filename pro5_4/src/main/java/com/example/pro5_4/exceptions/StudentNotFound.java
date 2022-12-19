package com.example.pro5_4.exceptions;

public class StudentNotFound extends RuntimeException{
    public StudentNotFound() {
        super("No such Student with this name");
    }
}
