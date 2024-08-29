package sim.guinee.service;

import java.util.*;
import java.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.EnqueteCollecte;
import sim.guinee.repository.EnqueteCollecteRepository;

@Service
public class EnqueteCollecteService {
    
    @Autowired
    EnqueteCollecteRepository fRepository;
    

    public EnqueteCollecte create(EnqueteCollecte f){
        f.setDateEnregistrement(LocalDate.now());
        return fRepository.save(f);
    }

    public EnqueteCollecte update(EnqueteCollecte f, int id){
        EnqueteCollecte fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("EnqueteCollecte non trouvé") );
        
        fo.setNumFiche(f.getNumFiche());
        fo.setMarche(f.getMarche());
        fo.setDateEnquete(f.getDateEnquete());
        fo.setCollecteur(f.getCollecteur());
        fo.setEtat(f.getEtat());
        fo.setModifierPar(f.getModifierPar());
        fo.setModifierLe(LocalDate.now());

        return fRepository.save(fo);
    }

    public EnqueteCollecte getById(int id) {
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("EnqueteCollecte non trouvé") );
    }

    public List<EnqueteCollecte> getAll() {
        List<EnqueteCollecte> fList = fRepository.findAll();

        if(fList.isEmpty()){
            throw new IllegalStateException("Aucun EnqueteCollecte trouvé");
        }

        return fList;
    }

    public String deleteEnqueteCollecte(int id ){
        EnqueteCollecte f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("EnqueteCollecte non trouvé") );
        fRepository.delete(f);
        return "Supprimé avec succèss";
    }
}
