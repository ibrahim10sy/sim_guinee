package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Marche;

@Repository
public interface MarcheRepository extends JpaRepository<Marche , Integer>{

    List<Marche> findByLocalite(String localite);

    List<Marche> findByCollecteur(String collecteur);

    List<Marche> findByJourMarche(String jour);

    List<Marche> findByTypeMarche(String type);

}
