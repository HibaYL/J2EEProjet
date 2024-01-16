package com.example.projet_spring.controller;

import com.example.projet_spring.entity.Salle;
import com.example.projet_spring.service.SalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SalleController {
    private final SalleService salleService;
    @PostMapping("/salle")
    public Salle postsalle(@RequestBody Salle salle){
        return salleService.postsalle(salle);
    }

    @GetMapping("/salles")
    private List<Salle> getAllSalle()
    {
        return salleService.getAllSalle();
    }
    @GetMapping("/salle/{id}")
    private ResponseEntity<Salle> getSalleById(@PathVariable  Long id)
    {
        Salle salle=salleService.getSalleById(id);
        if(salle==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(salle);
    }

    @PutMapping("/salle/{id}")
    private ResponseEntity<Salle> updateSalle(@PathVariable  Long id, @RequestBody Salle salle)
    {
        Salle existingSalle=salleService.getSalleById(id);
        if(existingSalle==null)
            return ResponseEntity.notFound().build();
        existingSalle.setName(salle.getName());
        existingSalle.setHoraire(salle.getHoraire());
        existingSalle.setPrix(salle.getPrix());
        existingSalle.setResponsable(salle.getResponsable());
        existingSalle.setExercices(salle.getExercices());
        Salle updateSalle=salleService.updateSalle(existingSalle);
        return ResponseEntity.ok(updateSalle);
    }
    @DeleteMapping ("/salle/{id}")

    private ResponseEntity<?> deleteSalle(@PathVariable  Long id){
        Salle existingSalle=salleService.getSalleById(id);
        if(existingSalle==null)
            return ResponseEntity.notFound().build();
        salleService.deleteSalle(id);
        return  ResponseEntity.ok().build();

    }

}
