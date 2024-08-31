package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "user_access")
public class UserAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idPersonnel;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String pageEdit;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String pageVerif;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String pageValid;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String pageInterd;

    @Column(nullable = false)
    private Long personnel;

    @Column(nullable = false)
    private LocalDate dateEnregistrement;

    @Column(nullable = true)
    private LocalDate dateModification;
    
}
