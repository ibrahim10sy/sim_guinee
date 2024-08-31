package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.*;
import sim.guinee.model.Client;
import sim.guinee.repository.ClientRepository;

@Service
public class ClientService {
    
     @Autowired
    ClientRepository fRepository;

    public Client create(Client f){
        f.setDateEnregistrement(LocalDate.now());

        return fRepository.save(f);
    }

    public Client update(Client f, Long id){
        Client fo = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Client non trouvé") );
        
        fo.setNomClient(f.getNomClient());
        fo.setAdresse(f.getAdresse());
        fo.setContact(f.getContact());
        fo.setLocalite(f.getLocalite());
        fo.setTypeClient(f.getTypeClient());
        fo.setModifierPar(f.getModifierPar());
        fo.setModifierLe(LocalDate.now());

        return fRepository.save(fo);
    }

    public Client getById(Long id) {
        return fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Client non trouvé") );
    }

    public List<Client> getAll() {
        List<Client> fList = fRepository.findAll();

        if(fList.isEmpty()){
            throw new IllegalStateException("Aucun Client trouvé");
        }

        return fList;
    }

    public String deleteClient(Long id ){
        Client f = fRepository.findById(id).orElseThrow(() -> new IllegalStateException("Client non trouvé") );
        fRepository.delete(f);
        return "Supprimé avec succèss";
    }
}
