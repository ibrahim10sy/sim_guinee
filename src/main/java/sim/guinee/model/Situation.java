package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "situation")
public class Situation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idid;

    @Column(length = 20, nullable = false)
    private String contact;

    @Column(nullable = false)
    private Long nombre;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Long position;

}
