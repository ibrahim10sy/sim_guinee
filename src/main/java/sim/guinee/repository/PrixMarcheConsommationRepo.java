package sim.guinee.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
import sim.guinee.model.PrixMarcheConsommation;
import sim.guinee.model.PrixMarcheGrossiste;

@Repository
public interface PrixMarcheConsommationRepo extends JpaRepository<PrixMarcheConsommation, Long  >{
 
    List<PrixMarcheConsommation> findByProduit(String produit);

    // récupérer les 10 derniers enregistrements
    @Query("SELECT p FROM PrixMarcheConsommation p ORDER BY p.dateEnregistrement DESC")
    List<PrixMarcheConsommation> findTop10ByOrderByDateEnregistrementDesc(Pageable pageable);


}
