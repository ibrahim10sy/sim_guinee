package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.FicheCollecte;
import sim.guinee.repository.FicheCollecteRepository;
import java.util.*;

@Service
public class FicheCollecteService {
    
    @Autowired 
    FicheCollecteRepository fRepository;

    public FicheCollecte create( FicheCollecte f){
        return fRepository.save(f);
    }

    public FicheCollecte update(FicheCollecte f, Long id){
        FicheCollecte fc = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune fiche de collecte trouvée") );
        fc.setEnquete(f.getEnquete());
        fc.setStatut(f.getStatut());
        fc.setObservation(f.getObservation());
        return fRepository.save(fc);
    }

    public FicheCollecte getById(Long id){
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune fiche de collecte trouvée") );
    }

    public List<FicheCollecte> getAll(){
        List<FicheCollecte> fc =  fRepository.findAll();

        if(fc.isEmpty()){
            throw new IllegalStateException("Aucune fiche de collecte trouvée");
        }

        return fc;
    }

    public List<FicheCollecte> getAllByEnquete(Long id){
        List<FicheCollecte> fc =  fRepository.findByEnquete(id);

        if(fc.isEmpty()){
            throw new IllegalStateException("Aucune fiche de collecte trouvée");
        }

        return fc;
    }
    
    public String delete(Long  id){
        FicheCollecte f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune fiche de collecte trouvée") );
        fRepository.delete(f);
        return "Fiche de collecte supprimée avec succès";
    }
}
