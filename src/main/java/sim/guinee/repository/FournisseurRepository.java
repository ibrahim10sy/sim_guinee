package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Fournisseur;

@Repository
public interface FournisseurRepository  extends JpaRepository<Fournisseur,Long >{
} 
