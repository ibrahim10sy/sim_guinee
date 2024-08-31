package sim.guinee.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categorie_produits")
public class CategorieProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorieProduit;

    @Column(length = 30, nullable = false)
    private String codeCategorieProduit;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String nomCategorieProduit;

    @Column(length = 30, nullable = false)
    private String familleProduit;

}
