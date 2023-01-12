package com.example.pro5_11.repository;

import com.example.pro5_11.entity.Wife;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WifeRepo extends JpaRepository<Wife, Integer> {
}
