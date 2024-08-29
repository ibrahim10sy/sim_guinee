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
    private int id;

    @Column(nullable = false)
    private int idid;

    @Column(length = 20, nullable = false)
    private String contact;

    @Column(nullable = false)
    private int nombre;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private int position;

}
