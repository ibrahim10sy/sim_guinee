package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.EnqueteCollecte;

@Repository
public interface EnqueteCollecteRepository extends JpaRepository<EnqueteCollecte,Integer>{
}
