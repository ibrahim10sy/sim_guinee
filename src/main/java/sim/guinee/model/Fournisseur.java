package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "fournisseur")
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFournisseur;

    @Column(length = 100, nullable = false)
    private String code;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomFournisseur;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String adresse;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String contact;

    @Column(length = 100, nullable = true)
    private String localite;

    @Column(nullable = false )
    private int typeFournisseur = 0;

    @Column( nullable = true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String idPersonnel;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String modifierPar;

}
