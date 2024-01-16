package com.example.projet_spring.controller;

import com.example.projet_spring.entity.exercice;
import com.example.projet_spring.service.exerciceservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class exercicecontroller {
private final exerciceservice exerciceService;
@PostMapping("/exercice")
public exercice postexercice(@RequestBody exercice Exercice){
    return exerciceService.postexercice(Exercice);
}

    @GetMapping("/exercices")
 private List<exercice> getAllExercice()
{
        return exerciceService.getAllExercice();
    }
    @GetMapping("/exercice/{id}")
    private ResponseEntity<exercice> getExerciceById(@PathVariable  Long id)
    {
        exercice Exercice=exerciceService.getExerciceById(id);
        if(Exercice==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(Exercice);
    }
    @PutMapping("/exercice/{id}")
    private ResponseEntity<exercice> updateExercice(@PathVariable  Long id, @RequestBody exercice Exercice)
    {
     exercice existingExercice=exerciceService.getExerciceById(id);
     if(existingExercice==null)
         return ResponseEntity.notFound().build();
     existingExercice.setName(Exercice.getName());
     existingExercice.setDescription(Exercice.getDescription());
     existingExercice.setDuree(Exercice.getDuree());
     existingExercice.setNbrep(Exercice.getNbrep());
     existingExercice.setType(Exercice.getType());
     existingExercice.setDate(Exercice.getDate());
     existingExercice.setProgramme(Exercice.getProgramme());
     existingExercice.setSalle(Exercice.getSalle());
     exercice updateExercice=exerciceService.updateExercice(existingExercice);
     return ResponseEntity.ok(updateExercice);
    }
    @DeleteMapping ("/exercice/{id}")

    private ResponseEntity<?> deleteExercice(@PathVariable  Long id){
        exercice existingExercice=exerciceService.getExerciceById(id);
        if(existingExercice==null)
            return ResponseEntity.notFound().build();
        exerciceService.deleteExercice(id);
        return  ResponseEntity.ok().build();

    }
}
