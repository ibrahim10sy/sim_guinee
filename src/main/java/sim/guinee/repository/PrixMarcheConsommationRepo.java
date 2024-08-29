package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import sim.guinee.model.PrixMarcheConsommation;

@Repository
public interface PrixMarcheConsommationRepo extends JpaRepository<PrixMarcheConsommation, Integer >{
 
    List<PrixMarcheConsommation> findByProduit(String produit);


}
