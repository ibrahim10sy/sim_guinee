package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "village")
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVillage;

    @Column(length = 20, nullable = false)
    private String codeVillage;

    @Column(length = 20, nullable = false)
    private String commune;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomVillage;

    @Column(length = 10,nullable= true)
    private String abregeVillage;

    @Column(length = 11, nullable = true)
    private int homme;

    @Column(length = 11, nullable = true)
    private int femme;

    @Column(length = 11, nullable = true)
    private int jeune;

    @Column(length = 11, nullable = true)
    private int menage;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String idPersonnel;

    @Column(nullable = false)
    private LocalDateTime dateEnregistrement;

    @Column(length = 10,nullable = true)
    private String etat;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String modifierPar;

    @Column(nullable = true)
    private LocalDate modifierLe;
 
}
