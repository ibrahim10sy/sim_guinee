package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.PrixMarcheCollecte;
import sim.guinee.repository.PrixMarcheCollecteRepo;

@Service
public class PrixMarcheCollecteService {
    
    @Autowired 
    CodeGenerator codeGenerator;
    @Autowired 
    PrixMarcheCollecteRepo pRepository;

    public PrixMarcheCollecte create(PrixMarcheCollecte p){
        p.setDateEnregistrement(LocalDate.now());
        return pRepository.save(p);
    }

    public PrixMarcheCollecte update(PrixMarcheCollecte p , int id){
        PrixMarcheCollecte pr = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun prix grossiste trouvé") );

        pr.setEnquete(p.getEnquete());
        pr.setProduit(p.getProduit());
        pr.setUnite(p.getUnite());
        pr.setPoidsUnitaire(p.getPoidsUnitaire());
        pr.setMontantAchat(p.getMontantAchat());
        pr.setPrixFgKg(p.getPrixFgKg());
        pr.setLocaliteOrigine(p.getLocaliteOrigine());
        pr.setDistanceOrigineMarche(p.getDistanceOrigineMarche());
        pr.setMontantTransport(p.getMontantTransport());
        pr.setEtatRoute(p.getEtatRoute());
        pr.setQuantiteCollecte(p.getQuantiteCollecte());
        pr.setClientPrincipal(p.getClientPrincipal());
        pr.setFournisseurPrincipal(p.getFournisseurPrincipal());
        pr.setNiveauApprovisionnement(p.getFournisseurPrincipal());
        pr.setAppMobile(p.getAppMobile());
        pr.setObservation(p.getObservation());
        pr.setStatut(p.getStatut());
        pr.setEtat(p.getEtat());
        pr.setModifierPar(p.getModifierPar());
        pr.setModifierLe(LocalDate.now());

        return pRepository.save(pr);

    }

    public List<PrixMarcheCollecte> getAll(){
        List<PrixMarcheCollecte> pList = pRepository.findAll();
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }

    public List<PrixMarcheCollecte> getAllByProduit(String nom){
        List<PrixMarcheCollecte> pList = pRepository.findByProduit(nom);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }

    public List<PrixMarcheCollecte> getAllByGrossiste(String nom){
        List<PrixMarcheCollecte> pList = pRepository.findByLocaliteOrigine(nom);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }
  
    public PrixMarcheCollecte getById(int id){
        return pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun prix grossiste trouvé") );
    }
    
    public String deletePrix(int id){
        PrixMarcheCollecte p = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun prix grossiste non trouvé") );
        pRepository.delete(p);
        return "Prix grossiste supprimé avec succès";
    }   

}
