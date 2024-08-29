package sim.guinee.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "envoi_msg")
public class EnvoiMsg {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT", nullable=true)
    private String region;

    @Column(nullable=true)
    private int collecteur;

    @Column(nullable=true)
    private int relai;

    @Column(nullable=true)
    private int abonne;

    @Column(nullable=true)
    private int radio;

    @Column(nullable=true)
    private int ca;

    @Column(nullable = false)
    private int uropc;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String msg;

    @Column( nullable = false)
    private LocalDateTime date;

    @Column( length = 11, nullable = true)
    private String statut = "OUI";

}
