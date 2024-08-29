package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Personnel;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {

    Personnel findByContact(String contact);

    Personnel findByEmail(String email);
    
}
