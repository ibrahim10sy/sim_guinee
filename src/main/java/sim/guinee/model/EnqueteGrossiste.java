package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "enquete_grossiste")
public class EnqueteGrossiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEnquete;

    @Column(length = 100, nullable = false)
    private String numFiche;

    @Column(length = 100, nullable = false)
    private String marche;

    @Column(nullable = false)
    private LocalDate dateEnquete;

    @Column(length = 30, nullable = false)
    private String collecteur;

    @Column(nullable = true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String idPersonnel;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String etat;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String modifierPar;
   
}
