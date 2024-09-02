package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "prix_marche_consommation")
public class PrixMarcheConsommation {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFiche;

    @Column(length = 20, nullable = false)
    private long enquete;

    @Column(length = 100, nullable = false)
    private String produit;

    @Column( nullable = false)
    private Long unite;

    @Column( nullable = false)
    private double poidsUnitaire;

    @Column( nullable = false)
    private double prixMesure;

    @Column( nullable = false)
    private double prixKgLitre;

    @Column( nullable = false)
    private Long niveauApprovisionnement;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String observation;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String document;

    @Column( nullable = false)
    private int appMobile = 0;

    @Column( nullable = false)
    private int statut = 0;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String idPersonnel;

    @Column( nullable = true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String etat;

    @Column( nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String modifierPar;
   
}
