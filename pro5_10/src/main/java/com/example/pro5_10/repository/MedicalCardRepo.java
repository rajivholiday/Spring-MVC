package com.example.pro5_10.repository;

import com.example.pro5_10.entity.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCardRepo extends JpaRepository<MedicalCard, Integer> {
}
