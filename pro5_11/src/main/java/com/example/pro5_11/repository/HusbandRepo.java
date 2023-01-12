package com.example.pro5_11.repository;

import com.example.pro5_11.entity.Husband;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HusbandRepo extends JpaRepository<Husband, Integer> {
}
