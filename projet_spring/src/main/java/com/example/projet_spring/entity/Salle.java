package com.example.projet_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name="salle")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String horaire;
    private float prix;

    private String adresse;
    private String responsable;
    @OneToMany(mappedBy = "salle")
    private Collection<exercice> exercices;
}
