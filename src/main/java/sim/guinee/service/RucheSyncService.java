package sim.guinee.service;

import java.time.LocalDateTime;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.RucheSync;
import sim.guinee.model.Village;
import sim.guinee.repository.RucheSyncRepository;

@Service
public class RucheSyncService {
    
    @Autowired
    RucheSyncRepository rRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public RucheSync create(RucheSync r ){
       String code = codeGenerator.genererCode();
        r.setDateEnregistrement(LocalDateTime.now());
        r.setCode(code);
        return rRepository.save(r);
    }

    public RucheSync update(RucheSync r , int id){
        RucheSync ru = rRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune donné  trouvé") );

        ru.setType(r.getType());
        ru.setEtat(r.getEtat());

        return rRepository.save(ru);
    }

    public  List<RucheSync> getAll(){
        List<RucheSync> rList =  rRepository.findAll();

        if(rList.isEmpty()){
            throw new IllegalStateException("Aucune donné trouvé");
        }

        return rList;
    }

   public String deleteRuche(int id){
       RucheSync r   = rRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune donné trouvé") );
        rRepository.delete(r);
        return "Supprimée avec succès";
    }
}
