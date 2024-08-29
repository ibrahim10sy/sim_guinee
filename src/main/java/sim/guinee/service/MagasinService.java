package sim.guinee.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.*;
import sim.guinee.model.Magasin;
import sim.guinee.repository.MagasinRepository;

@Service
public class MagasinService {
   
    @Autowired 
    MagasinRepository mRepository;
    @Autowired
    CodeGenerator codeGenerator;


    public Magasin create(Magasin m){
        String code = codeGenerator.genererCode();
        m.setCodeMagasin(code);
        m.setDateEnregistrement(LocalDate.now());
        return mRepository.save(m);
    }

    public Magasin update(Magasin m, int id){
        Magasin ma = mRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun magasin trouvé") );
        
        ma.setNomMagasin(m.getNomMagasin());
        ma.setNomMarche(m.getNomMarche());
        ma.setLongitude(m.getLongitude());
        ma.setLatitude(m.getLatitude());
        ma.setLocaliteMagasin(m.getLocaliteMagasin());
        ma.setContactMagasin(m.getContactMagasin());
        ma.setModifierPar(m.getModifierPar());
        ma.setModifierLe(m.getModifierLe());

        return mRepository.save(ma);
    }

    public Magasin getById(int id){
        return mRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun magasin trouvé") );
    }

    public List<Magasin> getAll(){
        List<Magasin> m =  mRepository.findAll();

        if(m.isEmpty()){
            throw new IllegalStateException("Aucun magasin trouvé");
        }
        return m;
    }

    public List<Magasin> getAllByLocalite(String localite){
        List<Magasin> m =  mRepository.findByLocaliteMagasin(localite);

        if(m.isEmpty()){
            throw new IllegalStateException("Aucun magasin trouvé");
        }
        return m;
    }

    public List<Magasin> getAllByMarche(String nom){
        List<Magasin> m =  mRepository.findByNomMarche(nom);

        if(m.isEmpty()){
            throw new IllegalStateException("Aucun magasin trouvé");
        }
        return m;
    }

     public String deleteMagasin(int id){
        Magasin m = mRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun magasin trouvé") );

        mRepository.delete(m);

        return "Supprimé avec succèss";
    }
}
