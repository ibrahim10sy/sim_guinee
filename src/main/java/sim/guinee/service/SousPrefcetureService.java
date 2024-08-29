package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.SousPrefecture;
import sim.guinee.repository.SousPRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class SousPrefcetureService {
 
    @Autowired 
    SousPRepository sRepository;

    public SousPrefecture create(SousPrefecture s){
        SousPrefecture sous = sRepository.findByNomSousPrefecture(s.getNomSousPrefecture());
       
        if(sous != null){
            throw new IllegalStateException("Ce sous prefecture existe déjà trouvé");
        }

        s.setDateEnregistrement(LocalDate.now());
        return sRepository.save(s);
    }

    public SousPrefecture update(SousPrefecture s, int id){
        SousPrefecture sous = sRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune sous prefecture trouvé") );

        sous.setNomSousPrefecture(s.getNomSousPrefecture());
        sous.setEtat(s.getEtat());
        sous.setModifierPar(s.getModifierPar());
        sous.setModifierLe(LocalDate.now());

        return sRepository.save(sous);
    }

    public List<SousPrefecture> getAll(){
        List<SousPrefecture> sousList = sRepository.findAll();
        
        if(sousList.isEmpty()){
            throw new IllegalStateException("Aucune sous prefecture trouvé");
        } 

        return sousList;
    }
    public List<SousPrefecture> getAllByIdPrefecture(int id ){
        List<SousPrefecture> sousList = sRepository.findByPrefecture(id);
        
        if(sousList.isEmpty()){
            throw new IllegalStateException("Aucune sous prefecture trouvé");
        } 

        return sousList;
    }

    public SousPrefecture getById(int id){
        SousPrefecture sous = sRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune sous prefecture trouvé") );
        return sous;

    }
    public String deleteSousPrefecture(int id){
        SousPrefecture s = sRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune sous prefecture non trouvé") );

        sRepository.delete(s);
        return "Aucune sous prefecture trouvé";
    }


}
