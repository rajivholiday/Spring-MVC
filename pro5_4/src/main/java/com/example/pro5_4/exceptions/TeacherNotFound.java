package com.example.pro5_4.exceptions;

public class TeacherNotFound extends  RuntimeException{
    public TeacherNotFound(){
        super("No such Teacher with this name");
    }
}
