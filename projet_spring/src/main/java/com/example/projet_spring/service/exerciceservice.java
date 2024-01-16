package com.example.projet_spring.service;

import com.example.projet_spring.entity.exercice;
import com.example.projet_spring.repository.exercice_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class exerciceservice {
    private final exercice_repository Exercice_Repository;
    public exercice postexercice(exercice Exercice)
    {
        return Exercice_Repository.save(Exercice);  }
    public List<exercice> getAllExercice()
    {
        return Exercice_Repository.findAll();  }
    public exercice getExerciceById(Long id ){
        return  Exercice_Repository.findById(id).orElse(null);
    }
    public exercice updateExercice(exercice Exercice ){
        return  Exercice_Repository.save(Exercice);
    }
    public void deleteExercice(Long id ){
        Exercice_Repository.deleteById(id);
    }

}
