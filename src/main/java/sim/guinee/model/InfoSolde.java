package sim.guinee.model;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "info_solde")
public class InfoSolde {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=true)
    private LocalDate date;

    @Column( nullable = false)
    private int statut = 0;
  
}
