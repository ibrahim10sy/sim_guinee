package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Fonction;

@Repository

public interface FonctionRepository extends JpaRepository<Fonction,Integer> {

    Fonction findByFonction(String fonction);
}
