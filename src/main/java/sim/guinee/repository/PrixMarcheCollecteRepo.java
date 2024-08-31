package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

import sim.guinee.model.PrixMarcheCollecte;

@Repository
public interface PrixMarcheCollecteRepo extends JpaRepository<PrixMarcheCollecte, Long >{
    
    List<PrixMarcheCollecte> findByProduit(String produit);



    List<PrixMarcheCollecte> findByLocaliteOrigine(String localiteOrigine);

    // List<PrixMarcheCollecte> findByLocaliteVente(String localiteVente);
    // List<PrixMarcheCollecte> findByFournisseurAchat(int fournisseurAchat);
    // List<PrixMarcheCollecte> findByProduitAndLocaliteVente(String produit, String localiteVente);
}
