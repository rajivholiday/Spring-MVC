package com.example.pro5_7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String salary;

    @OneToOne
    @JoinColumn(name = "d_id", referencedColumnName = "doc_id") // d_id -> employee; doc_id -> document

    private Document document;


}
