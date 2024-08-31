package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.Prefecture;
import sim.guinee.repository.PrefectureRepository;

@Service
public class PrefectureService {
    
    @Autowired 
    PrefectureRepository sRepository;

    public Prefecture create(Prefecture s){
        Prefecture sous = sRepository.findByNomPrefecture(s.getNomPrefecture());
       
        if(sous != null){
            throw new IllegalStateException("Cette prefecture existe déjà trouvé");
        }

        s.setDateEnregistrement(LocalDate.now());
        return sRepository.save(s);
    }

    public Prefecture update(Prefecture s, Long id){
        Prefecture sous = sRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune sous prefecture trouvé") );

        sous.setRegion(s.getRegion());
        sous.setNomPrefecture(s.getNomPrefecture());
        sous.setZoneopp(s.getZoneopp());
        sous.setEtat(s.getEtat());
        sous.setModifierPar(s.getModifierPar());
        sous.setModifierLe(LocalDate.now());

        return sRepository.save(sous);
    }

    public List<Prefecture> getAll(){
        List<Prefecture> sousList = sRepository.findAll();
        
        if(sousList.isEmpty()){
            throw new IllegalStateException("Aucune sous prefecture trouvé");
        } 

        return sousList;
    }
    public List<Prefecture> getAllByRegion(Long region){
        List<Prefecture> sousList = sRepository.findByRegion(region);
        
        if(sousList.isEmpty()){
            throw new IllegalStateException("Aucune sous prefecture trouvé");
        } 

        return sousList;
    }

    public Prefecture getById(Long id){
        return sRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune sous prefecture trouvé") );
    }
    
    public String deletePrefecture(Long id){
        Prefecture s = sRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune prefecture non trouvé") );

        sRepository.delete(s);
        return "Prefecture supprimé avec succèss";
    }

}
