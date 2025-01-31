
package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.CategorieProduit;

@Repository
public interface CategorieProduitRepository  extends JpaRepository<CategorieProduit,Integer>{

    List<CategorieProduit> findByFamilleProduit(String nom);
} 
