package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.TypeDetaillant;

@Repository
public interface TypeDetaillantRepository extends JpaRepository<TypeDetaillant, Integer> {
    
}
