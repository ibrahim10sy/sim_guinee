package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.FamilleProduit;

@Repository

public interface FamilleRepository extends JpaRepository<FamilleProduit,Integer>{
}
