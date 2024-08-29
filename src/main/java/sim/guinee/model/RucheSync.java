package sim.guinee.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.Data;

@Entity
@Data
@Table(name = "ruche_sync")
public class RucheSync {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int type = 0;

    @Column(columnDefinition = "LONGTEXT",nullable=true)
    private String code;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String idPersonnel;

    @Column(nullable = false)
    private LocalDateTime dateEnregistrement;

    @Column(nullable = false)
    private int etat = 0;
 
}
