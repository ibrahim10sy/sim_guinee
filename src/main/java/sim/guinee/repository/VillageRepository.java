package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Village;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long > {

    Village findByNomVillage(String nomVillage);

    List<Village> findByCommune(Long id );
    
}
