package sim.guinee.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
import sim.guinee.model.EnqueteConsommation;
import sim.guinee.model.EnqueteGrossiste;

@Repository
public interface EnqueteGrossisteRepository extends JpaRepository<EnqueteGrossiste,Long>{
      // récupérer les 10 derniers enregistrements
    @Query("SELECT p FROM EnqueteGrossiste p ORDER BY p.dateEnregistrement DESC")
    List<EnqueteGrossiste> findTop10ByOrderByDateEnregistrementDesc(Pageable pageable);

}
