package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Grossiste;

@Repository
public interface GrossisteRepository extends JpaRepository<Grossiste,Integer>{
}
