package com.example.projet_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="equipement")
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String taille;

    private int poids;
    private String disponibilite;
}
