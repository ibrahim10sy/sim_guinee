package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

import org.hibernate.type.TrueFalseConverter;

@Entity
@Data
@Table(name = "region_produit")
public class RegionProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegionProduit;

    @Column(length = 30 , nullable = true)
    private String codeRegionProduit;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomRegionProduit;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String formeConcerne;

    @Column(nullable = false)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String idPersonnel;

    @Column(columnDefinition = "TEXT" , nullable = true)
    private String etat;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String modifierPar;
 
}
