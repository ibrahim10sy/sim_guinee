package sim.guinee.service;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import sim.guinee.model.AutreMsg;
import sim.guinee.repository.AutreMsgRepository;

public class AutreMsgService {
    
    @Autowired
    AutreMsgRepository fRepository;

    public AutreMsg create(AutreMsg f){
        f.setDate(LocalDateTime.now());
        return fRepository.save(f);
    }

    public AutreMsg update(AutreMsg f, int id){
        AutreMsg fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("AutreMsg non trouvé") );
        fo.setExpediteur(f.getExpediteur());
        fo.setMsg(f.getMsg());
        return fRepository.save(fo);
    }

    public AutreMsg getById(int id) {
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("AutreMsg non trouvé") );
    }

    public List<AutreMsg> getAll() {
        List<AutreMsg> fList = fRepository.findAll();

        if(fList.isEmpty()){
            throw new IllegalStateException("Aucun AutreMsg trouvé");
        }

        return fList;
    }

    public String deleteAutreMsg(int id ){
        AutreMsg f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("AutreMsg non trouvé") );
        fRepository.delete(f);
        return "Supprimé avec succèss";
    }
}
