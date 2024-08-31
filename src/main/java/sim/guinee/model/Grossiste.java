package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "grossiste")
public class Grossiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrossiste;

    @Column(length = 100, nullable = false)
    private String code;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nom;

    @Column(length = 20, nullable = false)
    private String contact;

    @Column(length = 30, nullable = false)
    private String localite;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String adresse;

    @Column(nullable = true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String idPersonnel;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String etat;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String modifierPar;

}
