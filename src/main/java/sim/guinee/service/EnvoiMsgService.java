package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
import sim.guinee.model.EnvoiMsg;
import sim.guinee.repository.EnvoiMsgRepository;

@Service 
public class EnvoiMsgService {
 
    @Autowired
    EnvoiMsgRepository eRepository;

    public EnvoiMsg create(EnvoiMsg e ){
        e.setDate(LocalDateTime.now());
        return eRepository.save(e);
    } 

    public EnvoiMsg update(EnvoiMsg e, Long id){
        EnvoiMsg en = eRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune envoi trouvé") );
        en.setRegion(e.getRegion());
        en.setCollecteur(e.getCollecteur());
        en.setRelai(e.getRelai());
        en.setAbonne(e.getAbonne());
        en.setRadio(e.getRadio());
        en.setCa(e.getCa());
        en.setUropc(e.getUropc());
        en.setMsg(e.getMsg());
        return eRepository.save(en);
    }

    public EnvoiMsg getById(Long id){
        return eRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune envoi trouvé") );
    }

    public List<EnvoiMsg> getAll(){
        List<EnvoiMsg> m =  eRepository.findAll();
        if(m.isEmpty()){
            throw new IllegalStateException("Aucune envoi trouvé");
        }
        return m;
    }

    public String delete(Long id){
        EnvoiMsg e = eRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune envoi trouvé") );
        eRepository.delete(e);
        return "Supprimé avec succès";
    }
}
