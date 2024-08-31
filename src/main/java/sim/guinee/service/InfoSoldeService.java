package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import sim.guinee.model.InfoSolde;
import sim.guinee.repository.InfoSoldeRepository;

@Service
public class InfoSoldeService {
    
    @Autowired 
    InfoSoldeRepository iRepository;

    public InfoSolde create(InfoSolde i){
        return iRepository.save(i);
    }

    public InfoSolde update(InfoSolde i, Long id){
        InfoSolde si = iRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun solde trouvé") );
        si.setDate(i.getDate());
        si.setStatut(i.getStatut());
        return iRepository.save(si);
    }

    public List<InfoSolde> getInfoSoldeList(){
        List<InfoSolde> i = iRepository.findAll();

        if(i.isEmpty()){
            throw new IllegalStateException("Aucun solde trouvé");
        }

        return i;
    }

    public InfoSolde getInfoById(Long id){
        return iRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun solde trouvé") );
    }
    
    public String deleteInfo(Long id){
        InfoSolde si = iRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun solde trouvé") );
        iRepository.delete(si);
        return "Supprimé avec succèss";
    }


}
