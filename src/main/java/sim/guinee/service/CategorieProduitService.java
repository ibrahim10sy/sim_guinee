package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.*;
import sim.guinee.model.CategorieProduit;
import sim.guinee.repository.CategorieProduitRepository;

@Service
public class CategorieProduitService {
    
    @Autowired
    CategorieProduitRepository fRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public CategorieProduit create(CategorieProduit f){
        String code = codeGenerator.genererCode();
        f.setCodeCategorieProduit(code);
        return fRepository.save(f);
    }

    public CategorieProduit update(CategorieProduit f, Long id){
        CategorieProduit fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("CategorieProduit non trouvé") );
        
        fo.setNomCategorieProduit(f.getNomCategorieProduit());    
        fo.setNomCategorieProduit(f.getNomCategorieProduit());
        fo.setFamilleProduit(f.getFamilleProduit());

        return fRepository.save(fo);
    }

    public CategorieProduit getById(Long id) {
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("CategorieProduit non trouvé") );
    }

    public List<CategorieProduit> getAll() {
        List<CategorieProduit> fList = fRepository.findAll();

        if(fList.isEmpty()){
            throw new IllegalStateException("Aucun CategorieProduit trouvé");
        }

        return fList;
    }
    public List<CategorieProduit> getAllByFamilleProduit(String familleProduit) {
        List<CategorieProduit> fList = fRepository.findByFamilleProduit(familleProduit);

        if(fList.isEmpty()){
            throw new IllegalStateException("Aucun CategorieProduit trouvé");
        }

        return fList;
    }

    public String deleteCategorieProduit(Long id ){
        CategorieProduit f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("CategorieProduit non trouvé") );
        fRepository.delete(f);
        return "Supprimé avec succèss";
    }
}
