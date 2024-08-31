package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.RegionProduit;

@Repository
public interface RegionProduitRepository extends JpaRepository<RegionProduit, Long > {

    RegionProduit findByNomRegionProduit(String nomRegionProduit);
    
}
