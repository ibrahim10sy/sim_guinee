package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.UniteMesure;

@Repository
public interface UniteMesureRepository extends JpaRepository<UniteMesure, Long > {

    UniteMesure findByNomUnite(String nomUnite);
    
}
