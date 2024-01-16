package com.example.projet_spring.service;

import com.example.projet_spring.entity.Programme;
import com.example.projet_spring.repository.ProgrammeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProgrammeService {
    private final ProgrammeRepository programmeRepository;
    public Programme postProgramme(Programme programme)
    {
        return programmeRepository.save(programme);  }
    public List<Programme> getAllProgramme()
    {
        return programmeRepository.findAll();  }
    public Programme getProgrammeById(Long id ){
        return  programmeRepository.findById(id).orElse(null);
    }
    public Programme updateProgramme(Programme programme ){
        return  programmeRepository.save(programme);
    }
    public void deleteProgramme(Long id ){
        programmeRepository.deleteById(id);
    }

}
