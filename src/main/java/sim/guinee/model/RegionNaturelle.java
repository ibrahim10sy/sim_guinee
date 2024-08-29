package sim.guinee.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "region_naturelle")
public class RegionNaturelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegionNaturelle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String nomRegionNaturelle;

}
