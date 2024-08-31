package sim.guinee.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "famille_produit")
public class FamilleProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFamilleProduit;

    @Column(nullable = false, length = 30)
    private String codeFamilleProduit;

    @Column(nullable = false)
    private String nomFamilleProduit;

    @Column(nullable = false)
    private LocalDate dateEnregistrement;

    @Column(nullable = true)
    private String idPersonnel;

    @Column(nullable = true)
    private String etat;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(nullable = true)
    private String modifierPar;
}
