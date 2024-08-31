package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.RucheSync;

@Repository
public interface RucheSyncRepository extends JpaRepository<RucheSync, Long > {
    
}
