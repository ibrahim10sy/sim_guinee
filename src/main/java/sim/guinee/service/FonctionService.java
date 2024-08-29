package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.Fonction;
import sim.guinee.repository.FonctionRepository;
import java.util.*;

@Service
public class FonctionService {
 
    @Autowired
    FonctionRepository fRepository;

    public Fonction create(Fonction f){
        Fonction fo = fRepository.findByFonction(f.getFonction());

        if(fo != null){
            throw new IllegalArgumentException("Fonction déjà existante");
        }

        return fRepository.save(f);
    }

    public Fonction update(Fonction f, int id){
        Fonction fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune fonction trouvé") );
        fo.setFonction(f.getFonction());
        fo.setDescription(f.getFonction());
        fo.setService(f.getService());

        return fRepository.save(fo);
    }

    public List<Fonction> getAll(){
        List<Fonction> fList = fRepository.findAll();
        if(fList.isEmpty()){
            throw new IllegalStateException("Aucune fonction trouvé");
        }
        return fList;
    }
    
    public String deleteFonction(Integer id){
        Fonction f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune fonction trouvé") );
        fRepository.delete(f);
        return "Supprimée avec succès";
    }

    public Fonction getById(int id){
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune fonction trouvé") );
    }

}
