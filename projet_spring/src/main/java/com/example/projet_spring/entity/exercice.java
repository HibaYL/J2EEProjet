package com.example.projet_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="exercice")
public class exercice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float duree;
    private int nbrep;
    private String type;
    private Date date;
    @ManyToOne
    private Programme programme;
    @ManyToOne
    private Salle salle;
}
