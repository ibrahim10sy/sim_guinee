package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Parametrage;

@Repository
public interface  ParametrageRepository extends JpaRepository<Parametrage, Integer>{
    
}
