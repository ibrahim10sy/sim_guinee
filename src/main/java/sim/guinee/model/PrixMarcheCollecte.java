package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "prix_marche_collecte")
public class PrixMarcheCollecte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFiche;

    @Column(nullable=false)
    private long enquete;

    @Column(length = 100, nullable = false)
    private String produit;

    @Column(nullable=false)
    private int unite;

    @Column(nullable=false)
    private double poidsUnitaire;

    @Column(nullable=false)
    private double montantAchat;

    @Column(nullable=false)
    private double prixFgKg;

    @Column(length = 100, nullable = false)
    private String localiteOrigine;

    @Column(nullable=false)
    private double distanceOrigineMarche;

    @Column(nullable=false)
    private double montantTransport;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String etatRoute;

    @Column(nullable=false)
    private double quantiteCollecte;

    @Column(nullable=false)
    private int clientPrincipal = 0;

    @Column(nullable=false)
    private int fournisseurPrincipal = 0;

    @Column(nullable=false)
    private int niveauApprovisionnement;

    @Column(nullable=false)
    private int appMobile = 0;

    @Column(columnDefinition = "TEXT" ,nullable=true)
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
