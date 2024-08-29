package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.NiveauApprovisionement;
import sim.guinee.repository.NiveauRepository;

@Service
public class NiveauService {
    
    @Autowired 
    NiveauRepository nRepository;

    public NiveauApprovisionement create(NiveauApprovisionement n){
        n.setDateEnregistrement(LocalDate.now());
        return nRepository.save(n);
    }

    public NiveauApprovisionement update(NiveauApprovisionement n, int id){
        NiveauApprovisionement ni = nRepository.findById(id).orElseThrow(() -> new IllegalStateException("Niveau d'approvisionnement non trouvé") );

        ni.setNiveauApprovisionnement(n.getNiveauApprovisionnement());
        ni.setModifierPar(n.getModifierPar());
        ni.setModifierLe(n.getModifierLe());

        return nRepository.save(ni);
    }

    public NiveauApprovisionement getById(int id){
        return nRepository.findById(id).orElseThrow(() -> new IllegalStateException("Niveau d'approvisionnement non trouvé") );
    }

    public List<NiveauApprovisionement> getAll(){
        List<NiveauApprovisionement> nList = nRepository.findAll();
        if(nList.isEmpty()){
            throw new IllegalStateException("Aucun niveau d'approvisionnement trouvé");
        }
        return nList;
    }

    public String deleteNiveau(int id){
        NiveauApprovisionement n = nRepository.findById(id).orElseThrow(() -> new IllegalStateException("Niveau d'approvisionnement non trouvé") );

        nRepository.delete(n);
        return "Supprimé avec succèss";
    }
}
