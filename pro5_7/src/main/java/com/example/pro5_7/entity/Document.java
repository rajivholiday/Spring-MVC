package com.example.pro5_7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")   // it is optional
    private int id;
    @Column
    private String name;
    @Column
    private String number;
    @OneToOne(mappedBy = "document")
    private Employee employee;
}
