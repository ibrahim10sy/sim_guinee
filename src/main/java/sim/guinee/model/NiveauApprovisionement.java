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
    private int idNiveauApprovisionnement;

    @Column( length = 100, nullable = false)
    private String niveauApprovisionnement;

    @Column( nullable = false)
    private LocalDate dateEnregistrement;

    @Column( nullable = false, columnDefinition = "TEXT")
    private String idPersonnel;

    @Column( nullable = false)
    private LocalDate modifierLe;

    @Column( columnDefinition = "TEXT", nullable = false)
    private String modifierPar;
}
