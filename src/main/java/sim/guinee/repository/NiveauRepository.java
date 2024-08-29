package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.NiveauApprovisionement;

@Repository
public interface NiveauRepository extends JpaRepository<NiveauApprovisionement,Integer>{

}
