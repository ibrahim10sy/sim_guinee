package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.FormeProduit;
import sim.guinee.repository.FormeProduitRepository;

@Service
public class FormeProduitService {
    
    @Autowired
    FormeProduitRepository fRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public FormeProduit create (FormeProduit p){
        String code = codeGenerator.genererCode();
        p.setCodeFormeProduit(code);
        p.setDateEnregistrement(LocalDate.now());
        return fRepository.save(p);
    }

    public FormeProduit update(FormeProduit f,Long id){
        FormeProduit fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun forme produit non trouvé") );

        fo.setNomFormeProduit(f.getNomFormeProduit());
        fo.setProduitConcerne(f.getProduitConcerne());
        fo.setEtat(f.getEtat());
        fo.setModifierPar(f.getModifierPar());
        fo.setModifierLe(LocalDate.now());

        return fRepository.save(fo);
    }

    public List<FormeProduit> getAll(){
        List<FormeProduit> forme = fRepository.findAll();

        if(forme.isEmpty()){
            throw new IllegalStateException("Aucun forme trouvé");
        }
        return forme;
    }

    public FormeProduit getById(Long id){
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun forme trouvé"));
    }

    public String deleteFormeProduit(Long id){
        FormeProduit f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune forme produit non trouvé") );
        fRepository.delete(f);
        return "Supprimé avec succèss";
    }

}
