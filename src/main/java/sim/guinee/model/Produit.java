package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduit;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String codeProduit;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomProduit;

    @Column(nullable = false)
    private int familleProduit;

    @Column(nullable = false)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String idPersonnel;

    @Column(columnDefinition = "TEXT", nullable = true)
    private int idMagasin;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String etat;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String modifierPar;
 
}
