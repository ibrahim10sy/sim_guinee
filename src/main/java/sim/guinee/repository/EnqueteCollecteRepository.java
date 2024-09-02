package sim.guinee.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
import sim.guinee.model.EnqueteCollecte;
import sim.guinee.model.PrixMarcheGrossiste;

@Repository
public interface EnqueteCollecteRepository extends JpaRepository<EnqueteCollecte,Long>{

    // récupérer les 10 derniers enregistrements
    @Query("SELECT p FROM EnqueteCollecte p ORDER BY p.dateEnregistrement DESC")
    List<EnqueteCollecte> findTop10ByOrderByDateEnregistrementDesc(Pageable pageable);


}
