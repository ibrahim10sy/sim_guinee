package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import sim.guinee.model.PrixMarcheGrossiste;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface PrixMarcheGrossisteRepo  extends JpaRepository<PrixMarcheGrossiste, Long >{
    
    List<PrixMarcheGrossiste> findByProduit(String produit);

    List<PrixMarcheGrossiste> findByGrossiste(String grossiste);

    // récupérer les 10 derniers enregistrements
    @Query("SELECT p FROM PrixMarcheGrossiste p ORDER BY p.dateEnregistrement DESC")
    List<PrixMarcheGrossiste> findTop10ByOrderByDateEnregistrementDesc(Pageable pageable);

    List<PrixMarcheGrossiste> findByLocaliteAchat(String localiteAchat);

    List<PrixMarcheGrossiste> findByLocaliteVente(String localiteVente);
    List<PrixMarcheGrossiste> findByFournisseurAchat(int fournisseurAchat);
    List<PrixMarcheGrossiste> findByProduitAndLocaliteVente(String produit, String localiteVente);
}
