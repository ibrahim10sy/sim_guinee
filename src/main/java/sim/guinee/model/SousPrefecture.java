package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "sous_prefecture")
public class SousPrefecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSousPrefecture;

    @Column(nullable = false)
    private int prefecture;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String nomSousPrefecture;

    @Column(columnDefinition = "TEXT" ,nullable = true)
    private String idPersonnel;

    @Column(nullable = true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String etat;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String modifierPar;
   
}
