
package sim.guinee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.AutreMsg;

@Repository
public interface AutreMsgRepository  extends JpaRepository<AutreMsg,Long>{

} 
