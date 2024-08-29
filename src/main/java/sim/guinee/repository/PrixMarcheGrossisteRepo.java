package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import sim.guinee.model.PrixMarcheGrossiste;

@Repository
public interface PrixMarcheGrossisteRepo  extends JpaRepository<PrixMarcheGrossiste, Integer>{
    
    List<PrixMarcheGrossiste> findByProduit(String produit);

    List<PrixMarcheGrossiste> findByGrossiste(String grossiste);

    List<PrixMarcheGrossiste> findByLocaliteAchat(String localiteAchat);

    List<PrixMarcheGrossiste> findByLocaliteVente(String localiteVente);
    List<PrixMarcheGrossiste> findByFournisseurAchat(int fournisseurAchat);
    List<PrixMarcheGrossiste> findByProduitAndLocaliteVente(String produit, String localiteVente);
}
