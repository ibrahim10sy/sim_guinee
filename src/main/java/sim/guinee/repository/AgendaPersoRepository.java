
package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.AgendaPerso;

@Repository
public interface AgendaPersoRepository  extends JpaRepository<AgendaPerso,Long>{

    List<AgendaPerso> findByIdPersonnel(String id);

} 
