package sim.guinee.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "enquete_consommation")
public class EnqueteConsommation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnquete;

    @Column( nullable = false, length = 100)
    private String numFiche;

    @Column( nullable = false, length = 100)
    private String marche;

    @Column( nullable = false)
    private LocalDate dateEnquete;

    @Column( nullable = false, length = 30)
    private String collecteur;

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
