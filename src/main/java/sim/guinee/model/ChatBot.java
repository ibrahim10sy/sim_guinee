package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "chat")
public class ChatBot {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChat;

    @Column( nullable = true)
    private String nomClient;

    @Column( nullable = true)
    private String observation;

    @Column(nullable = true)
    private String adresse;

    @Column(nullable = true)
    private String contact;

    @Column(nullable = false)
    private LocalDateTime dateEnregistrement;

}
