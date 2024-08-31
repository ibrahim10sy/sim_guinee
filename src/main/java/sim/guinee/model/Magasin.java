package sim.guinee.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Magasin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMagasin;

    @Column(nullable = false)
    private String codeMagasin;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String nomMarche;

    @Column(nullable = false)
    private String nomMagasin;

    @Column( nullable = false)
    private Double longitude = 0.0;

    @Column( nullable = false)
    private Double latitude = 0.0;

    @Column(nullable = false)
    private String localiteMagasin;

    @Column(nullable = false)
    private String contactMagasin;

     @Column(nullable=true)
    private LocalDate dateEnregistrement;

    @Column(nullable = true, length = 100)
    private String modifierPar;

    @Column(nullable=true)
    private LocalDate modifierLe;
}
