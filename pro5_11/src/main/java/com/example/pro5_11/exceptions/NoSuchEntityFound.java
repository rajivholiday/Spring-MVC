package com.example.pro5_11.exceptions;

public class NoSuchEntityFound extends  RuntimeException{
    public NoSuchEntityFound(){
        super("No such Entity found");
    }
}
