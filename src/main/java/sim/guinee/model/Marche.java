package sim.guinee.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "marche")
public class Marche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMarche;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String nomMarche;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String typeMarche;

    @Column( nullable = false, length = 30)
    private String codeMarche;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String jourMarche;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String collecteur;

    @Column( nullable = false, length = 30)
    private String localite;

    @Column( nullable = false)
    private Double longitude = 0.0;

    @Column( nullable = false)
    private Double latitude = 0.0;

    @Column(nullable = false)
    private Double superficie = 0.0;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String description;

    @Column(nullable=true, length = 100)
    private String idPersonnel;

    @Column(nullable=true)
    private LocalDate dateEnregistrement;

    @Column(nullable = true, length = 100)
    private String modifierPar;

    @Column(nullable=true)
    private LocalDate modifierLe;
  
}
