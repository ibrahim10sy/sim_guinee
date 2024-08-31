package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegion;

    @Column(length = 30, nullable = false)
    private String codeRegion;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomRegion;

    @Column(length = 30, nullable = false)
    private String abregeRegion;

    @Column( nullable = true)
    private Long regionNaturelle;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String couleur;

    @Column(columnDefinition = "TEXT" , nullable = true)
    private String personnel;

    @Column(nullable = true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String etat;

    @Column(columnDefinition = "TEXT")
    private String modifierPar;

    @Column(nullable = true)
    private LocalDate modifierLe;
   
}
