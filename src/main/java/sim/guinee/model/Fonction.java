package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "fonction")
public class Fonction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFonction;

    @Column(columnDefinition = "TEXT",nullable=true)
    private String fonction;

    @Column(columnDefinition = "TEXT" ,nullable=true)
    private String description;

    @Column(columnDefinition = "TEXT" ,nullable=true)
    private String service;

}
