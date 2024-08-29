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

    public PrixMarcheConsommation update(PrixMarcheConsommation p , int id){
        PrixMarcheConsommation pr = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun prix grossiste trouvé") );

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
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }

    public List<PrixMarcheConsommation> getAllByProduit(String nom){
        List<PrixMarcheConsommation> pList = pRepository.findByProduit(nom);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }

    public PrixMarcheConsommation getById(int id){
        return pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun prix grossiste non trouvé") );
    }
   
    public String deletePrix(int id){
        PrixMarcheConsommation p = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun prix grossiste non trouvé") );
        pRepository.delete(p);
        return "Prix consommation supprimé avec succès";
    }   
}
