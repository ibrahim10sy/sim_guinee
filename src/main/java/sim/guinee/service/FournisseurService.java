package sim.guinee.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import sim.guinee.model.Fournisseur;
import sim.guinee.repository.FournisseurRepository;

@Service
public class FournisseurService {
 
    @Autowired
    FournisseurRepository fRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public Fournisseur create(Fournisseur f){
        f.setDateEnregistrement(LocalDate.now());
        String code = codeGenerator.genererCode();
        f.setCode(code);
        return fRepository.save(f);
    }

    public Fournisseur update(Fournisseur f, Long id){
        Fournisseur fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Fournisseur non trouvé") );
        
        fo.setNomFournisseur(f.getNomFournisseur());
        fo.setAdresse(f.getAdresse());
        fo.setContact(f.getContact());
        fo.setLocalite(f.getLocalite());
        fo.setTypeFournisseur(f.getTypeFournisseur());
        fo.setModifierPar(f.getModifierPar());
        fo.setModifierLe(LocalDate.now());

        return fRepository.save(fo);
    }

    public Fournisseur getById(Long id) {
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Fournisseur non trouvé") );
    }

    public List<Fournisseur> getAll() {
        List<Fournisseur> fList = fRepository.findAll();

        if(fList.isEmpty()){
            throw new IllegalStateException("Aucun fournisseur trouvé");
        }

        return fList;
    }

    public String deleteFournisseur(Long id ){
        Fournisseur f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Fournisseur non trouvé") );
        fRepository.delete(f);
        return "Supprimé avec succèss";
    }
}
