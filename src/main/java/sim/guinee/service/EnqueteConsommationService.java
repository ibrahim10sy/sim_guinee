package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.*;
import java.time.*;

import org.springframework.stereotype.Service;

import sim.guinee.model.EnqueteConsommation;
import sim.guinee.model.EnqueteGrossiste;
import sim.guinee.repository.EnqueteConsommationRepository;

@Service
public class EnqueteConsommationService {
    
    @Autowired
    EnqueteConsommationRepository fRepository;
    

    public EnqueteConsommation create(EnqueteConsommation f){
        f.setDateEnregistrement(LocalDate.now());
        return fRepository.save(f);
    }

    public EnqueteConsommation update(EnqueteConsommation f, Long id){
        EnqueteConsommation fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("EnqueteConsommation non trouvé") );
        
        fo.setNumFiche(f.getNumFiche());
        fo.setMarche(f.getMarche());
        fo.setDateEnquete(f.getDateEnquete());
        fo.setCollecteur(f.getCollecteur());
        fo.setEtat(f.getEtat());
        fo.setModifierPar(f.getModifierPar());
        fo.setModifierLe(LocalDate.now());

        return fRepository.save(fo);
    }

    public EnqueteConsommation getById(Long id) {
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("EnqueteConsommation non trouvé") );
    }

    public List<EnqueteConsommation> getAll() {
        List<EnqueteConsommation> fList = fRepository.findAll();

        if(fList.isEmpty()){
            throw new IllegalStateException("Aucun EnqueteConsommation trouvé");
        }

        return fList;
    }

      public List<EnqueteConsommation> getAllTop10prix() {
        // Crée un PageRequest pour obtenir 10 enregistrements, triés par date en ordre décroissant
        PageRequest pageRequest = PageRequest.of(0, 10);
        return fRepository.findTop10ByOrderByDateEnregistrementDesc(pageRequest);
    }

    public String deleteEnqueteConsommation(Long id ){
        EnqueteConsommation f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("EnqueteConsommation non trouvé") );
        fRepository.delete(f);
        return "Supprimé avec succèss";
    }
}
