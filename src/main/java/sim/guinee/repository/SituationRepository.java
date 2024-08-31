package sim.guinee.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Situation;

@Repository
public interface SituationRepository extends JpaRepository<Situation, Long > {

    List<Situation> findByDate(LocalDate date);
    
}
