package sim.guinee.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Magasin;

@Repository
public interface MagasinRepository extends JpaRepository<Magasin ,Integer>{

    List<Magasin> findByLocaliteMagasin(String localite);

    List<Magasin> findByNomMarche(String nom);

  

}
