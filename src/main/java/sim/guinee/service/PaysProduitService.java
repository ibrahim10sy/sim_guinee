package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.PaysProduit;
import sim.guinee.repository.PaysProduitRepository;

@Service
public class PaysProduitService {
    
    @Autowired
    PaysProduitRepository pRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public PaysProduit create(PaysProduit p){
        String code = codeGenerator.genererCode();
        p.setCodePaysProduit(code);
        return pRepository.save(p);
    }

    public PaysProduit update(PaysProduit p, int id){
        PaysProduit pays = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun pays trouvé") );
        pays.setNomPaysProduit(p.getNomPaysProduit());
        pays.setRegionProduit(p.getRegionProduit());

        return pRepository.save(pays);
    }
    
    public List<PaysProduit> getAll(){
        List<PaysProduit> pList = pRepository.findAll();
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun pays trouvé");
        }

        return pList;
    }
    public List<PaysProduit> getByRegion(String region){
        List<PaysProduit> pList = pRepository.findByRegionProduit(region);
        
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun pays trouvé");
        }
        
        return pList;
    }

    public PaysProduit getById(int id){
        return pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun pays trouvé") );
    }

    public String delete(int id){
        PaysProduit pays = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun pays trouvé") );
        pRepository.delete(pays);
        return "Supprimé avec succèss";
    }
}
