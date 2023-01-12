package com.example.pro5_10.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Medical_Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String reg_number;
    @Column
    private String doc_number;

    @OneToOne(mappedBy = "medical_card")
    Person person;

}
