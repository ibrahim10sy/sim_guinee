package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String codeProduit;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomProduit;

    @Column(nullable = false)
    private Long familleProduit;

    @Column(nullable = false)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String idPersonnel;

    @Column(columnDefinition = "TEXT", nullable = true)
    private Long idMagasin;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String etat;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String modifierPar;
 
    @ElementCollection
    @CollectionTable(name = "images_produit", joinColumns = @JoinColumn(name = "id_produit"))
    @Column(name = "image_path")
    private List<String> images = new ArrayList<>();
}