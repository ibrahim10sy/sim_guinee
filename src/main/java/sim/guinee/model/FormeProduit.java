package sim.guinee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "forme_produit")
public class FormeProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forme_produit")
    private Integer idFormeProduit;

    @Column(name = "code_forme_produit", nullable = false, length = 30)
    private String codeFormeProduit;

    @Column(name = "nom_forme_produit", nullable = false, columnDefinition = "TEXT")
    private String nomFormeProduit;

    @Column( nullable = true, columnDefinition = "TEXT")
    private String produitConcerne;

    @Column( nullable = false)
    private LocalDate dateEnregistrement;

    @Column( columnDefinition = "TEXT", nullable = true)
    private String idPersonnel;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String etat;

    @Column( nullable = true)
    private LocalDate modifierLe;

    @Column( columnDefinition = "TEXT", nullable = true)
    private String modifierPar;

}
