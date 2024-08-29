package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.InfoSolde;

@Repository
public interface InfoSoldeRepository  extends JpaRepository<InfoSolde,Integer>{

}
