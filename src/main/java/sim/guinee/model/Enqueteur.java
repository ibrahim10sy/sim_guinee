package sim.guinee.model;


import jakarta.persistence.*;

import java.time.LocalDate;

import lombok.Data;


@Entity
@Data
@Table(name = "enqueteur")
public class Enqueteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnqueteur;

    @Column(length = 30, nullable = false)
    private String code;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nom;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String prenom;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String sexe;

    @Column(length = 20, nullable = false)
    private String contact;

    @Column(length = 30, nullable = false)
    private String localite;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String adresse;

    @Column(nullable = false)
    private int superviseur;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(length = 100, nullable = true)
    private String appProfil;

    @Column(nullable = true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String idPersonnel;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String etat;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String modifierPar;
   
}
