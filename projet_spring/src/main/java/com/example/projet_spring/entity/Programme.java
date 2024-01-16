package com.example.projet_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name="programme")
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cout;
    private String niveau;
    private String instructeur;
    @OneToMany(mappedBy = "programme")
    private Collection<exercice> exercices;

}
