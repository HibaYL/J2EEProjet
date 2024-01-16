package com.example.projet_spring.repository;

import com.example.projet_spring.entity.exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface exercice_repository extends JpaRepository<exercice,Long> {
}
