package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.EnqueteGrossiste;

@Repository
public interface EnqueteGrossisteRepository extends JpaRepository<EnqueteGrossiste,Long>{
}
