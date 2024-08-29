package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.FicheCollecte;

@Repository
public interface FicheCollecteRepository  extends JpaRepository<FicheCollecte,Integer>{

    List<FicheCollecte> findByEnquete(int id);
}
