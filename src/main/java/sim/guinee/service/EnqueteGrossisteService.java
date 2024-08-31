package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.*;
import sim.guinee.model.EnqueteGrossiste;
import sim.guinee.repository.EnqueteGrossisteRepository;

@Service
public class EnqueteGrossisteService {
    
    @Autowired
    EnqueteGrossisteRepository fRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public EnqueteGrossiste create(EnqueteGrossiste f){
        f.setDateEnregistrement(LocalDate.now());
        return fRepository.save(f);
    }

    public EnqueteGrossiste update(EnqueteGrossiste f, Long id){
        EnqueteGrossiste fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("EnqueteGrossiste non trouvé") );
        
        fo.setNumFiche(f.getNumFiche());
        fo.setMarche(f.getMarche());
        fo.setDateEnquete(f.getDateEnquete());
        fo.setCollecteur(f.getCollecteur());
        fo.setEtat(f.getEtat());
        fo.setModifierPar(f.getModifierPar());
        fo.setModifierLe(LocalDate.now());

        return fRepository.save(fo);
    }

    public EnqueteGrossiste getById(Long id) {
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("EnqueteGrossiste non trouvé") );
    }

    public List<EnqueteGrossiste> getAll() {
        List<EnqueteGrossiste> fList = fRepository.findAll();

        if(fList.isEmpty()){
            throw new IllegalStateException("Aucun EnqueteGrossiste trouvé");
        }

        return fList;
    }

    public String deleteEnqueteGrossiste(Long id ){
        EnqueteGrossiste f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("EnqueteGrossiste non trouvé") );
        fRepository.delete(f);
        return "Supprimé avec succèss";
    }
}
