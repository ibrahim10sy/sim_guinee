package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.UserAccess;

@Repository
public interface UserAccessRepository  extends JpaRepository<UserAccess, Integer>{
    
}
