package sim.guinee.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pays_produit")
public class PaysProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaysProduit;

    @Column(nullable = false, length = 30)
    private String codePaysProduit;

    @Column( nullable = false)
    private String nomPaysProduit;

    @Column( nullable = false, length = 30)
    private String regionProduit;

}
