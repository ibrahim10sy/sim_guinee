package sim.guinee.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "connecter")
public class Connecter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_connexion")
    private Long idConnexion;

    @Column(length = 50, nullable = false)
    private String personnel;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String sessionId;

    @Column(name = "date_connexion", nullable = false)
    private LocalDateTime dateConnexion;

    
    @Column(name = "date_deconnexion", nullable = false)
    private LocalDateTime dateDeconnexion;

    @Column(name = "date_c", nullable = false)
    private LocalDateTime dateC;
}
