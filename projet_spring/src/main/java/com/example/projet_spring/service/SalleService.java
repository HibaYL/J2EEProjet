package com.example.projet_spring.service;

import com.example.projet_spring.entity.Salle;
import com.example.projet_spring.repository.SalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SalleService {
    private final SalleRepository salleRepository;
    public Salle postsalle(Salle salle)
    {
        return salleRepository.save(salle);  }
    public List<Salle> getAllSalle()
    {
        return salleRepository.findAll();  }
    public Salle getSalleById(Long id ){
        return  salleRepository.findById(id).orElse(null);
    }


    public Salle updateSalle(Salle salle ){
        return  salleRepository.save(salle);
    }
    public void deleteSalle(Long id ){
        salleRepository.deleteById(id);
    }



}
