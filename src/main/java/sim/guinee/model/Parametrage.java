package sim.guinee.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "parametrage")
public class Parametrage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String projet;

    @Column(nullable = false)
    private String pays;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String adresse;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String contact;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String slogan;

    @Column(columnDefinition = "TEXT", nullable = false, length = 3)
    private String activerStock = "NON";

}
