package sim.guinee.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "niveau_approvisionement")
public class NiveauApprovisionement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveauApprovisionement;

    @Column( length = 100, nullable = false)
    private String niveauApprovisionement;

    @Column( nullable = false)
    private LocalDate dateEnregistrement;

    @Column( nullable = false, columnDefinition = "TEXT")
    private String idPersonnel;

    @Column( nullable = true)
    private LocalDate modifierLe;

    @Column( columnDefinition = "TEXT", nullable = true)
    private String modifierPar;
}
