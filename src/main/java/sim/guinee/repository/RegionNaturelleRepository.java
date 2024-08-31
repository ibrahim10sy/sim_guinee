package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.RegionNaturelle;

@Repository
public interface RegionNaturelleRepository extends JpaRepository<RegionNaturelle, Long >{

    RegionNaturelle findByNomRegionNaturelle(String nomRegionNaturelle);
    
}
