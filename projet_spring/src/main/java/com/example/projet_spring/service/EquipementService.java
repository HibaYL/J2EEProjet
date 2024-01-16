package com.example.projet_spring.service;

import com.example.projet_spring.entity.Equipement;
import com.example.projet_spring.repository.EquipementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EquipementService {
    private final EquipementRepository equipementRepository;
    public Equipement postEquipement(Equipement equipement)
    {
        return equipementRepository.save(equipement);  }
    public List<Equipement> getAllEquipement()
    {
        return equipementRepository.findAll();  }
    public Equipement getEquipementById(Long id ){
        return  equipementRepository.findById(id).orElse(null);
    }
    public Equipement updateEquipement(Equipement equipement ){
        return  equipementRepository.save(equipement);
    }
    public void deleteEquipement(Long id ){
        equipementRepository.deleteById(id);
    }

}
