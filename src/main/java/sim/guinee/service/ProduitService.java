package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.Produit;
import sim.guinee.repository.ProduitRepository;

@Service
public class ProduitService {
    
    @Autowired
    ProduitRepository pRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public Produit create(Produit p){
        String code = codeGenerator.genererCode();
        p.setCodeProduit(code);
        p.setDateEnregistrement(LocalDate.now());
        return pRepository.save(p);
    }

    public Produit updateProduit(Produit p, int id){
        Produit pr = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune produit trouvé avec id "+id) );

        pr.setNomProduit(p.getNomProduit());
        pr.setFamilleProduit(p.getFamilleProduit());
        pr.setEtat(p.getEtat());
        pr.setModifierLe(LocalDate.now());
        pr.setModifierPar(p.getModifierPar());

        return pRepository.save(pr);
    }

    public Produit getById(int id){
        return pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune produit trouvé avec id "+id) );
    }

    public List<Produit> getAllProduits(){
        List<Produit> pList = pRepository.findAll();

        if(pList.isEmpty()){
            throw new IllegalStateException("Aucune produit trouvé avec");

        }
        return pList;
    }
    public List<Produit> getAllProduitsByFamille(int id){
        List<Produit> pList = pRepository.findByFamilleProduit(id);

        if(pList.isEmpty()){
            throw new IllegalStateException("Aucune produit trouvé avec");

        }
        return pList;
    }
  
    public List<Produit> getAllProduitsByIdPersonnel(String id){
        List<Produit> pList = pRepository.findByIdPersonnel(id);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucune produit trouvé avec");

        }
        return pList;
    }
 
    public List<Produit> getAllProduitsByIdMagasin(int id){
        List<Produit> pList = pRepository.findByIdMagasin(id);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucune produit trouvé avec");

        }
        return pList;
    }

    public String deleteProduit(int id){
        Produit p = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune produit trouvé avec id "+id) );
        pRepository.delete(p);
        return "Produit supprimé avec succès";
    }
}
