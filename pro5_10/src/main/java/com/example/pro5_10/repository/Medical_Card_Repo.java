package com.example.pro5_10.repository;

import com.example.pro5_10.entity.Medical_Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Medical_Card_Repo extends JpaRepository<Medical_Card, Integer> {
}
