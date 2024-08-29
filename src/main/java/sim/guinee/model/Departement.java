package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "departement")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartement;

    @Column(length = 20, nullable = false)
    private String codeDepartement;

    @Column(length = 20, nullable = false)
    private String region;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomDepartement;

    @Column(length = 10, nullable = true)
    private String abregeDepartement;

    @Column(columnDefinition = "TEXT" , nullable = true)
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
