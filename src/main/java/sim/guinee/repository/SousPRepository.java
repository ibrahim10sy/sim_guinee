package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.SousPrefecture;

@Repository
public interface SousPRepository  extends  JpaRepository<SousPrefecture, Integer>{

    SousPrefecture findByNomSousPrefecture(String nomSousPrefecture);

    List<SousPrefecture> findByPrefecture(int id);
}
