package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.FormeProduit;

@Repository
public interface FormeProduitRepository extends JpaRepository<FormeProduit,Long >{
}
