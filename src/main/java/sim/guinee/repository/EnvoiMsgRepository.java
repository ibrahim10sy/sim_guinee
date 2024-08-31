package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.EnvoiMsg;

@Repository

public interface EnvoiMsgRepository extends JpaRepository<EnvoiMsg,Long >{
}
