package com.example.pro5_7.repository;

import com.example.pro5_7.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Integer> {

}
