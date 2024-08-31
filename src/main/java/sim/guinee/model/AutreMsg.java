package sim.guinee.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "autre_msg")
public class AutreMsg {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT",nullable = true)
    private String expediteur;
    
    @Column(columnDefinition = "TEXT",nullable = true)
    private String msg;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = true)
    private LocalDateTime date;
}
