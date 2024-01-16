package com.example.projet_spring.controller;

import com.example.projet_spring.entity.Programme;
import com.example.projet_spring.service.ProgrammeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api4")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProgrammeController {

    private final ProgrammeService programmeService;
    @PostMapping("/programme")
    public Programme postProgramme(@RequestBody Programme programme){
        return programmeService.postProgramme(programme);
    }

    @GetMapping("/programmes")
    private List<Programme> getAllProgramme()
    {
        return programmeService.getAllProgramme();
    }
    @GetMapping("/programme/{id}")
    private ResponseEntity<Programme> getProgrammeById(@PathVariable  Long id)
    {
        Programme programme=programmeService.getProgrammeById(id);
        if(programme==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(programme);
    }
    @PutMapping("/programme/{id}")
    private ResponseEntity<Programme> updateProgramme(@PathVariable  Long id, @RequestBody Programme programme)
    {
        Programme existingProgramme=programmeService.getProgrammeById(id);
        if(existingProgramme==null)
            return ResponseEntity.notFound().build();
        existingProgramme.setNiveau(programme.getNiveau());
        existingProgramme.setName(programme.getName());
        existingProgramme.setCout(programme.getCout());
        existingProgramme.setInstructeur(programme.getInstructeur());

        Programme updateProgramme=programmeService.updateProgramme(existingProgramme);
        return ResponseEntity.ok(updateProgramme);
    }
    @DeleteMapping ("/programme/{id}")

    private ResponseEntity<?> deleteProgramme(@PathVariable  Long id){
        Programme existingProgramme=programmeService.getProgrammeById(id);
        if(existingProgramme==null)
            return ResponseEntity.notFound().build();
        programmeService.deleteProgramme(id);
        return  ResponseEntity.ok().build();

    }
}
