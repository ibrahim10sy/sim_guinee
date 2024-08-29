package sim.guinee.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "prefecture")
public class Prefecture {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrefecture;

    @Column( nullable = false)
    private int region;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomPrefecture;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String zoneopp;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String idPersonnel;

    @Column(nullable = true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String etat;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String modifierPar;

    @Column(nullable = true)
    private LocalDate modifierLe;
 
}
