package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Commune;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, Long > {

    Commune findByNomCommune(String nomCommune);

    List<Commune> findByDepartement(String departement);
    
}
