package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "fiche_collecte")
public class FicheCollecte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFiche;

    @Column(nullable = false )
    private int enquete;

    @Column(length = 30, nullable = true)
    private String statut;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String observation;
  
}
