package sim.guinee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "agenda_perso")
public class AgendaPerso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgenda;

    @Column(columnDefinition = "TEXT" ,nullable = true)
    private String expediteur;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String titre;

    @Column(columnDefinition = "TEXT" ,nullable = true)
    private String description;

    @Column(name = "all_day", nullable = true)
    private int allDay = 0;

    @Column(nullable = false)
    private LocalDateTime debut;

    @Column(nullable = false)
    private LocalDateTime fin;

    @Column(length = 7, nullable = true)
    private String couleur;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String lien;

    @Column(nullable = false)
    private int valider = 0;

    @Column(nullable = false, columnDefinition = "ENUM('private','public')")
    private String type = "private";

    @Column(columnDefinition = "TEXT", nullable = true)
    private String idPersonnel;

    @Column(name = "date_enregistrement", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = true)
    private LocalDateTime dateEnregistrement;

    @Column(name = "modifier_le", nullable = true)
    private LocalDate modifierLe;

    @Column(name = "modifier_par", columnDefinition = "TEXT" ,nullable = true)
    private String modifierPar;

}