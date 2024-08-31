package sim.guinee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "commune")
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommune;

    @Column(length = 20, nullable = false)
    private String codeCommune;

    @Column(length = 20, nullable = false)
    private String departement;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomCommune;

    @Column(length = 10, nullable = true)
    private String abregeCommune;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String idPersonnel;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateEnregistrement;

    @Column(length = 10, nullable = true)
    private String etat;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String modifierPar;

    @Column(nullable = true)
    private LocalDate modifierLe;

}
