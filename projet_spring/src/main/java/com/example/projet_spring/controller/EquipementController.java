package com.example.projet_spring.controller;

import com.example.projet_spring.entity.Equipement;
import com.example.projet_spring.service.EquipementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api3")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EquipementController {
    private final EquipementService equipementService;
    @PostMapping("/equipement")
    public Equipement postEquipement(@RequestBody Equipement equipement){
        return equipementService.postEquipement(equipement);
    }

    @GetMapping("/equipements")
    private List<Equipement> getAllEquipement()
    {
        return equipementService.getAllEquipement();
    }
    @GetMapping("/equipement/{id}")
    private ResponseEntity<Equipement> getEquipementsById(@PathVariable Long id)
    {
        Equipement equipement=equipementService.getEquipementById(id);
        if(equipement==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(equipement);
    }
    @PutMapping("/equipement/{id}")
    private ResponseEntity<Equipement> updateEquipement(@PathVariable  Long id, @RequestBody Equipement equipement)
    {
        Equipement existingEquipement=equipementService.getEquipementById(id);
        if(existingEquipement==null)
            return ResponseEntity.notFound().build();
        existingEquipement.setType(equipement.getType());
        existingEquipement.setPoids(equipement.getPoids());
        existingEquipement.setTaille(equipement.getTaille());
        existingEquipement.setDisponibilite(equipement.getDisponibilite());
        Equipement updateEquipement=equipementService.updateEquipement(existingEquipement);
        return ResponseEntity.ok(updateEquipement);
    }
    @DeleteMapping ("/equipement/{id}")

    private ResponseEntity<?> deleteEquipement(@PathVariable  Long id){
        Equipement existingEquipement=equipementService.getEquipementById(id);
        if(existingEquipement==null)
            return ResponseEntity.notFound().build();
        equipementService.deleteEquipement(id);
        return  ResponseEntity.ok().build();

    }
}
