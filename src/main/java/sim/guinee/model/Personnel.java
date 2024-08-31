package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "personnel")
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long n;

    @Column(length = 100, nullable = false)
    private String code;

    @Column(length = 200, nullable = false)
    private String idPersonnel;

    @Column(length = 30 , nullable = true)
    private String titre;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String pass;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nom;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String prenom;

    @Column(length = 1000, nullable = false)
    private String appProfil = "fragment_main1,fragment_main2,fragment_main3";

    @Column(length = 30, nullable = true)
    private String contact;

    @Column(length = 60, nullable = true)
    private String email;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String fonction;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String descriptionFonction;

    @Column(columnDefinition = "TEXT" ,nullable = true)
    private String avatar;

    @Column(nullable = false)
    private int niveau = 5;

    @Column(nullable = true)
    private LocalDate dateEnregistrement;

    @Column(nullable = true)
    private LocalDate dateModification;

    @Column(nullable = false)
    private int statut = 0;
  
}
