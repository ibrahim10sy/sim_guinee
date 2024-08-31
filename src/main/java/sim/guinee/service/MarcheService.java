package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;
import sim.guinee.model.Marche;
import sim.guinee.repository.MarcheRepository;

@Service
public class MarcheService {
    
    @Autowired 
    MarcheRepository mRepository;
    @Autowired
    CodeGenerator codeGenerator;


    public Marche create(Marche m){
        String code = codeGenerator.genererCode();
        m.setCodeMarche(code);
        m.setDateEnregistrement(LocalDate.now());
        return mRepository.save(m);
    }

    public Marche update(Marche m, Long id){
        Marche ma = mRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun marché trouvé") );
        
        ma.setNomMarche(m.getNomMarche());
        ma.setTypeMarche(m.getTypeMarche());
        ma.setJourMarche(m.getJourMarche());
        ma.setCollecteur(m.getCollecteur());
        ma.setLocalite(m.getLocalite());
        ma.setLongitude(m.getLongitude());
        ma.setLatitude(m.getLatitude());
        ma.setSuperficie(m.getSuperficie());
        ma.setDescription(m.getDescription());
        ma.setModifierPar(m.getModifierPar());
        ma.setModifierLe(m.getModifierLe());

        return mRepository.save(ma);
    }

    public Marche getById(Long id){
        return mRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun marché trouvé") );
    }

    public List<Marche> getAll(){
        List<Marche> m =  mRepository.findAll();

        if(m.isEmpty()){
            throw new IllegalStateException("Aucun marché trouvé");
        }
        return m;
    }

    public List<Marche> getAllByLocalite(String localite){
        List<Marche> m =  mRepository.findByLocalite(localite);

        if(m.isEmpty()){
            throw new IllegalStateException("Aucun marché trouvé");
        }
        return m;
    }

    public List<Marche> getAllByCollecteur(String collecteur){
        List<Marche> m =  mRepository.findByCollecteur(collecteur);

        if(m.isEmpty()){
            throw new IllegalStateException("Aucun marché trouvé");
        }
        return m;
    }

    public List<Marche> getAllByJour(String jour){
        List<Marche> m =  mRepository.findByJourMarche(jour);

        if(m.isEmpty()){
            throw new IllegalStateException("Aucun marché trouvé");
        }
        return m;
    }

    public List<Marche> getAllByType(String type){
        List<Marche> m =  mRepository.findByTypeMarche(type);

        if(m.isEmpty()){
            throw new IllegalStateException("Aucun marché trouvé");
        }
        return m;
    }

    public String deleteMarche(Long id){
        Marche m = mRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun marché trouvé") );

        mRepository.delete(m);

        return "Supprimé avec succèss";
    }
}
