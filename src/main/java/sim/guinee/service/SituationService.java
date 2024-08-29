package sim.guinee.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import sim.guinee.model.Situation;
import sim.guinee.repository.SituationRepository;

@Service
public class SituationService {
    
    @Autowired
    SituationRepository sRepository; 
    
    public Situation create(Situation s){
        return sRepository.save(s);  
    }

    public Situation update(Situation s, int id){
        Situation si = sRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune situation  trouvé") );

        si.setIdid(s.getIdid());
        si.setContact(s.getContact());
        si.setNombre(s.getNombre());
        si.setDate(s.getDate());
        si.setPosition(s.getPosition());
        return sRepository.save(si);
    }

    public List<Situation> getAll(){
        List<Situation> sList = sRepository.findAll();

        if(sList.isEmpty()){
            throw new IllegalStateException("Aucune situation trouvé");
        }

        return sList;
    }
    public List<Situation> getAllByDate(LocalDate date){
        List<Situation> sList = sRepository.findByDate(date);

        if(sList.isEmpty()){
            throw new IllegalStateException("Aucune situation trouvé");
        }

        return sList;
    }

    public String deleteSituation(int id){
        Situation s = sRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune situation non trouvé") );
        
        sRepository.save(s);
        return "Supprimé avec succèss";
    }
}
