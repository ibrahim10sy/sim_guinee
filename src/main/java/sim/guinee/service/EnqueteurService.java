package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.*;

import sim.guinee.model.Enqueteur;
import sim.guinee.repository.EnqueteurRepository;

@Service
public class EnqueteurService {
    
    @Autowired
    EnqueteurRepository fRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public Enqueteur create(Enqueteur f){
        f.setDateEnregistrement(LocalDate.now());
        String code = codeGenerator.genererCode();
        f.setCode(code);
        return fRepository.save(f);
    }

    public Enqueteur update(Enqueteur f, int id){
        Enqueteur fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Enqueteur non trouvé") );
        
        fo.setNom(f.getNom());
        fo.setPrenom(f.getPrenom());
        fo.setSexe(f.getSexe());
        fo.setContact(f.getContact());
        fo.setLocalite(f.getLocalite());
        fo.setAdresse(f.getAdresse());
        fo.setSuperviseur(f.getSuperviseur());
        fo.setDescription(f.getDescription());
        fo.setAppProfil(f.getAppProfil());
        fo.setEtat(f.getEtat());
        fo.setModifierPar(f.getModifierPar());
        fo.setModifierLe(LocalDate.now());

        return fRepository.save(fo);
    }

    public Enqueteur getById(int id) {
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Enqueteur non trouvé") );
    }

    public List<Enqueteur> getAll() {
        List<Enqueteur> fList = fRepository.findAll();

        if(fList.isEmpty()){
            throw new IllegalStateException("Aucun Enqueteur trouvé");
        }

        return fList;
    }

    public String deleteEnqueteur(int id ){
        Enqueteur f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Enqueteur non trouvé") );
        fRepository.delete(f);
        return "Supprimé avec succèss";
    }
    
}
