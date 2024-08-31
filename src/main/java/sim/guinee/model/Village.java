package sim.guinee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "village")
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVillage;

    @Column(length = 20, nullable = false)
    private String codeVillage;

    @Column(length = 20, nullable = false)
    private Long commune;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomVillage;

    @Column(length = 10, nullable = true)
    private String abregeVillage;

    // Utilisation de Long  au lieu de int
    @Column(length = 11, nullable = true)
    private Long  homme;

    @Column(length = 11, nullable = true)
    private Long  femme;

    @Column(length = 11, nullable = true)
    private Long  jeune;

    @Column(length = 11, nullable = true)
    private Long  menage;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String idPersonnel;

    @Column(nullable = false)
    private LocalDateTime dateEnregistrement;

    @Column(length = 10, nullable = true)
    private String etat;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String modifierPar;

    @Column(nullable = true)
    private LocalDate modifierLe;

}
