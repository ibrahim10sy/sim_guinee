package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "unite_mesure")
public class UniteMesure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnite;

    @Column(length = 100, nullable = false)
    private String nomUnite;

    @Column(nullable = true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String idPersonnel;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String modifierPar;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String definition;

    @Column(nullable = true)
    private Double poidsIndicatif;
   
}
