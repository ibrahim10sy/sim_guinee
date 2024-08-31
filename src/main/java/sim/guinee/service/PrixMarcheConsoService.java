package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.PrixMarcheConsommation;
import sim.guinee.repository.PrixMarcheConsommationRepo;

@Service
public class PrixMarcheConsoService {
    
    @Autowired
    CodeGenerator codeGenerator;
    @Autowired 
    PrixMarcheConsommationRepo pRepository;

    public PrixMarcheConsommation create(PrixMarcheConsommation p){
        p.setDateEnregistrement(LocalDate.now());
        return pRepository.save(p);
    }

    public PrixMarcheConsommation update(PrixMarcheConsommation p , Long id){
        PrixMarcheConsommation pr = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun prix consommation trouvé") );

        pr.setEnquete(p.getEnquete());
        pr.setProduit(p.getProduit());
        pr.setUnite(p.getUnite());
        pr.setPoidsUnitaire(p.getPoidsUnitaire());
        pr.setPrixMesure(p.getPrixMesure());
        pr.setPrixKgLitre(p.getPrixKgLitre());
        pr.setNiveauApprovisionnement(p.getNiveauApprovisionnement());
        pr.setObservation(p.getObservation());
        pr.setDocument(p.getDocument());
        pr.setAppMobile(p.getAppMobile());
        pr.setStatut(p.getStatut());
        pr.setEtat(p.getEtat());
        pr.setModifierPar(p.getModifierPar());
        pr.setModifierLe(LocalDate.now());

        return pRepository.save(pr);

    }

    public List<PrixMarcheConsommation> getAll(){
        List<PrixMarcheConsommation> pList = pRepository.findAll();
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix consommation trouvé");
        }

        return pList;
    }

    public List<PrixMarcheConsommation> getAllByProduit(String produit){
        List<PrixMarcheConsommation> pList = pRepository.findByProduit(produit);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix consommation trouvé");
        }

        return pList;
    }

    public PrixMarcheConsommation getById(Long id){
        return pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun prix consommation non trouvé") );
    }
   
    public String deletePrix(Long id){
        PrixMarcheConsommation p = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun prix consommation non trouvé") );
        pRepository.delete(p);
        return "Prix consommation supprimé avec succès";
    }   
}
