package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

	Region findByNomRegion(String nomRegion);

    List<Region> findByRegionNaturelle(int id);
    
}
