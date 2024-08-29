package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    Departement findByNomDepartement(String nomDepartement);

    List<Departement> findByRegion(String nom);

    
}
