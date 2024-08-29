package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Enqueteur;

@Repository
public interface EnqueteurRepository extends JpaRepository<Enqueteur,Integer>{
}
