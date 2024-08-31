package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.PaysProduit;

@Repository
public interface PaysProduitRepository  extends JpaRepository<PaysProduit, Long >{

    List<PaysProduit> findByRegionProduit(String regionProduit);
    
}
