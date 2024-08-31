package sim.guinee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.Parametrage;
import sim.guinee.repository.ParametrageRepository;

@Service
public class ParametrageService {
    
    @Autowired
    ParametrageRepository pRepository;

    public Parametrage create(Parametrage p){
        return pRepository.save(p);
    }
    
    public Parametrage update(Parametrage p, Long id){
        Parametrage param = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun paramètre trouvé") );
        param.setProjet(p.getProjet());
        param.setPays(p.getPays());
        param.setAdresse(p.getAdresse());
        param.setContact(p.getContact());
        param.setSlogan(p.getSlogan());
        return pRepository.save(param);
    }

    public Parametrage getById(Long id){
        return pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun paramètre trouvé") );
    }

    public List<Parametrage> getAll(){
        List<Parametrage> pList = pRepository.findAll();

        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun paramètre trouvé");
        }
        return pList;
    }

    public String deleteParam(Long id){
        Parametrage p = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun paramètre trouvé") );
        pRepository.delete(p);
        return "Supprimé avec succéss";
    }
}
