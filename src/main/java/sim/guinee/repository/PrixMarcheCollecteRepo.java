package sim.guinee.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

import sim.guinee.model.PrixMarcheCollecte;
import sim.guinee.model.PrixMarcheConsommation;

@Repository
public interface PrixMarcheCollecteRepo extends JpaRepository<PrixMarcheCollecte, Long >{
    
    List<PrixMarcheCollecte> findByProduit(String produit);



    List<PrixMarcheCollecte> findByLocaliteOrigine(String localiteOrigine);

    // récupérer les 10 derniers enregistrements
    @Query("SELECT p FROM PrixMarcheCollecte p ORDER BY p.dateEnregistrement DESC")
    List<PrixMarcheCollecte> findTop10ByOrderByDateEnregistrementDesc(Pageable pageable);

    // List<PrixMarcheCollecte> findByLocaliteVente(String localiteVente);
    // List<PrixMarcheCollecte> findByFournisseurAchat(int fournisseurAchat);
    // List<PrixMarcheCollecte> findByProduitAndLocaliteVente(String produit, String localiteVente);
}
