package sim.guinee.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.Connecter;
import sim.guinee.model.Personnel;
import sim.guinee.repository.ConnecterRepository;

@Service
public class ConnecterService {
    
    @Autowired 
    ConnecterRepository cRepository;
    @Autowired
    CodeGenerator codeGenerator;
    @Autowired
    IdGenerator idGenerator;

    public Connecter create(Personnel p){
        Connecter c = new Connecter();

       
        String idCode = idGenerator.genererCode();
        c.setDateC(LocalDateTime.now());
        c.setDateConnexion(LocalDateTime.now());
        c.setPersonnel(p.getIdPersonnel());
        c.setSessionId(idCode);
     
        return cRepository.save(c);
    }
}
