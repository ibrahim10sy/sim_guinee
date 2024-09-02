package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "prix_marche_grossiste")
public class PrixMarcheGrossiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFiche;

    @Column(nullable=true)
    private Long enquete;

    @Column(length = 100,nullable=true)
    private String grossiste;

    @Column(length = 100, nullable = false)
    private String produit;

    @Column(nullable=false)
    private Long uniteStock;

    @Column(nullable=false)
    private double nombreUniteStock;

    @Column(nullable=false)
    private double poidsMoyenUniteStock;

    @Column(nullable=false)
    private double poidsStock;

    @Column(nullable=false)
    private Long uniteAchat;

    @Column(nullable=false)
    private double nombreUniteAchat;

    @Column(nullable=false)
    private double poidsMoyenUniteAchat;

    @Column(nullable=false)
    private double poidsTotalAchat;

    @Column(length = 100, nullable = false)
    private String localiteAchat;

    @Column(nullable=false)
    private int fournisseurAchat = 0;

    @Column(nullable=false)
    private Long uniteVente;

    @Column(nullable=false)
    private double nombreUniteVente;

    @Column(nullable=false)
    private double poidsMoyenUniteVente;

    @Column(nullable=false)
    private double poidsTotalUniteVente;

    @Column(nullable=false)
    private double prixUnitaireVente;

    @Column(nullable=false)
    private Long clientVente;

    @Column(length = 100, nullable = false)
    private String localiteVente;

    @Column(nullable=false)
    private int appMobile = 0;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String observation;

    @Column(nullable=false)
    private int statut = 0;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String idPersonnel;

    @Column(nullable=true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String etat;

    @Column(nullable=true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String modifierPar;
   
}
