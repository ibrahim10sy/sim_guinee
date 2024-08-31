package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.Prefecture;

@Repository
public interface PrefectureRepository extends JpaRepository<Prefecture, Long> {

    Prefecture findByNomPrefecture(String nomPrefecture);

    public List<Prefecture> findByRegion(Long region);
    
}
