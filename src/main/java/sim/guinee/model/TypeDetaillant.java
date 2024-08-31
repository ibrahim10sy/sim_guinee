package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "type_detaillant")
public class TypeDetaillant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeDetaillant;

    @Column(length = 100, nullable = false)
    private String typeDetaillant;

    @Column(nullable = true)
    private LocalDate dateEnregistrement;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String idPersonnel;

    @Column(nullable = true)
    private LocalDate modifierLe;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String modifierPar;
  
}
