package com.example.projet_spring.repository;

import com.example.projet_spring.entity.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammeRepository extends JpaRepository<Programme,Long> {
}
