package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.FamilleProduit;
import sim.guinee.repository.FamilleRepository;

@Service 
public class FamilleService {
    
    @Autowired
    FamilleRepository fRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public FamilleProduit create (FamilleProduit p){
        String code = codeGenerator.genererCode();
        p.setCodeFamilleProduit(code);
        p.setDateEnregistrement(LocalDate.now());
        return fRepository.save(p);
    }

    public FamilleProduit update(FamilleProduit f,int id){
        FamilleProduit fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun forme produit non trouvé") );

        fo.setNomFamilleProduit(f.getNomFamilleProduit());
        fo.setEtat(f.getEtat());
        fo.setModifierPar(f.getModifierPar());
        fo.setModifierLe(LocalDate.now());

        return fRepository.save(fo);
    }

    public List<FamilleProduit> getAll(){
        List<FamilleProduit> forme = fRepository.findAll();

        if(forme.isEmpty()){
            throw new IllegalStateException("Aucun forme trouvé");
        }
        return forme;
    }

    public FamilleProduit getById(int id){
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun forme trouvé"));
    }

    public String deleteFamilleProduit(int id){
        FamilleProduit f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune forme produit non trouvé") );
        fRepository.delete(f);
        return "Supprimé avec succèss";
    }

}
