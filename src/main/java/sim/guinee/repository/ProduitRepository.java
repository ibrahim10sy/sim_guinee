package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long > {

    List<Produit> findByFamilleProduit(Long id);

    List<Produit> findByIdPersonnel(String id);

    List<Produit> findByIdMagasin(Long id);
    
}
