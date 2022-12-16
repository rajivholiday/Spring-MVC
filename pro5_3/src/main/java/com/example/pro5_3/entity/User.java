package com.example.pro5_3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    private String surname;
    private int age;
    @Column(name = "postal code")
    private String postalCode;


}
