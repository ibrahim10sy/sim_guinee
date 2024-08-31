package sim.guinee.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import sim.guinee.model.Grossiste;
import sim.guinee.repository.GrossisteRepository;

@Service
public class GrossisteService {
    
     @Autowired
    GrossisteRepository fRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public Grossiste create(Grossiste f){
        f.setDateEnregistrement(LocalDate.now());
        String code = codeGenerator.genererCode();
        f.setCode(code);
        return fRepository.save(f);
    }

    public Grossiste update(Grossiste f, Long id){
        Grossiste fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Grossiste non trouvé") );
        
        fo.setNom(f.getNom());
        fo.setAdresse(f.getAdresse());
        fo.setContact(f.getContact());
        fo.setLocalite(f.getLocalite());
        fo.setModifierPar(f.getModifierPar());
        fo.setModifierLe(LocalDate.now());

        return fRepository.save(fo);
    }

    public Grossiste getById(Long id) {
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Grossiste non trouvé") );
    }

    public List<Grossiste> getAll() {
        List<Grossiste> fList = fRepository.findAll();

        if(fList.isEmpty()){
            throw new IllegalStateException("Aucun Grossiste trouvé");
        }

        return fList;
    }

    public String deleteGrossiste(Long id ){
        Grossiste f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Grossiste non trouvé") );
        fRepository.delete(f);
        return "Supprimé avec succèss";
    }
}
