package sim.guinee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomClient;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String adresse;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String contact;

    @Column(length = 100,nullable = true)
    private String localite;

    @Column(nullable = false, columnDefinition = "INT(11) DEFAULT 0")
    private Long typeClient;

    @Column(nullable = true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String idPersonnel;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String modifierPar;
}
