package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.PrixMarcheGrossiste;
import sim.guinee.repository.PrixMarcheGrossisteRepo;

@Service
public class PrixMarcheGrossisteService {
    
    @Autowired
    CodeGenerator codeGenerator;
    @Autowired 
    PrixMarcheGrossisteRepo pRepository;

    public PrixMarcheGrossiste create(PrixMarcheGrossiste p){
        p.setDateEnregistrement(LocalDate.now());
        return pRepository.save(p);
    }

    public PrixMarcheGrossiste update(PrixMarcheGrossiste p , Long id){
        PrixMarcheGrossiste pr = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun prix grossiste trouvé") );

        pr.setEnquete(p.getEnquete());
        pr.setGrossiste(p.getGrossiste());
        pr.setProduit(p.getProduit());
        pr.setUniteStock(p.getUniteStock());
        pr.setNombreUniteStock(p.getNombreUniteStock());
        pr.setPoidsMoyenUniteStock(p.getPoidsMoyenUniteStock());
        pr.setPoidsStock(p.getPoidsStock());
        pr.setUniteAchat(p.getUniteAchat());
        pr.setNombreUniteAchat(p.getNombreUniteAchat());
        pr.setPoidsMoyenUniteAchat(p.getPoidsMoyenUniteAchat());
        pr.setPoidsTotalAchat(p.getPoidsTotalAchat());
        pr.setLocaliteAchat(p.getLocaliteAchat());
        pr.setFournisseurAchat(p.getFournisseurAchat());
        pr.setUniteVente(p.getUniteVente());
        pr.setNombreUniteVente(p.getNombreUniteVente());
        pr.setPoidsMoyenUniteVente(p.getPoidsMoyenUniteVente());
        pr.setPoidsTotalUniteVente(p.getPoidsTotalUniteVente());
        pr.setPrixUnitaireVente(p.getPrixUnitaireVente());
        pr.setClientVente((p.getClientVente()));
        pr.setLocaliteVente(p.getLocaliteVente());
        pr.setAppMobile(p.getAppMobile());
        pr.setObservation(p.getObservation());
        pr.setStatut(p.getStatut());
        pr.setEtat(p.getEtat());
        pr.setModifierPar(p.getModifierPar());
        pr.setModifierLe(LocalDate.now());

        return pRepository.save(pr);

    }

    public List<PrixMarcheGrossiste> getAll(){
        List<PrixMarcheGrossiste> pList = pRepository.findAll();
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }

    public List<PrixMarcheGrossiste> getAllByProduit(String produit){
        List<PrixMarcheGrossiste> pList = pRepository.findByProduit(produit);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }

    public List<PrixMarcheGrossiste> getAllByGrossiste(String nom){
        List<PrixMarcheGrossiste> pList = pRepository.findByGrossiste(nom);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }
    public List<PrixMarcheGrossiste> getAllByLocaliteAchat(String nom){

        List<PrixMarcheGrossiste> pList = pRepository.findByLocaliteAchat(nom);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }

    public List<PrixMarcheGrossiste> getAllByPoduitAndLoc(String nom,String loc ){

        List<PrixMarcheGrossiste> pList = pRepository.findByProduitAndLocaliteVente(nom,loc);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }

    public List<PrixMarcheGrossiste> getAllByLocaliteVente(String nom){

        List<PrixMarcheGrossiste> pList = pRepository.findByLocaliteVente(nom);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }

    public List<PrixMarcheGrossiste> getAllByFournisseur(int id){

        List<PrixMarcheGrossiste> pList = pRepository.findByFournisseurAchat(id);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun prix grossiste trouvé");
        }

        return pList;
    }


    public String deletePrix(Long id){
        PrixMarcheGrossiste p = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun prix grossiste non trouvé") );
        pRepository.delete(p);
        return "Prix grossiste supprimé avec succès";
    }   

}
