package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.EnqueteConsommation;

@Repository
public interface EnqueteConsommationRepository extends JpaRepository<EnqueteConsommation,Integer>{
}
