package com.example.pro5_4.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column
    private String name;
    @Column
    private String surname;
}
