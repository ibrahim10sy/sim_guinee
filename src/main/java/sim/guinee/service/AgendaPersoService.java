package sim.guinee.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import sim.guinee.model.AgendaPerso;
import sim.guinee.repository.AgendaPersoRepository;

@Service
public class AgendaPersoService {
    
    @Autowired
    AgendaPersoRepository aRepository;

    public AgendaPerso create(AgendaPerso a){
        a.setDateEnregistrement(LocalDateTime.now());
        return aRepository.save(a);
    }

    public AgendaPerso update(AgendaPerso a, int id){
        AgendaPerso ag = aRepository.findById(id).orElseThrow(() -> new IllegalStateException("AgendaPerso non trouvé") );

        ag.setExpediteur(a.getExpediteur());
        ag.setTitre(a.getTitre());
        ag.setDescription(a.getDescription());
        ag.setAllDay(a.getAllDay());
        ag.setDebut(a.getDebut());
        ag.setFin(a.getFin());
        ag.setCouleur(a.getCouleur());
        ag.setLien(a.getLien());
        ag.setValider(a.getValider());
        ag.setType(a.getType());
        ag.setModifierLe(LocalDate.now());
        ag.setModifierPar(a.getModifierPar());

        return aRepository.save(ag);
    }



    public  List<AgendaPerso> getAllAgendaPerso() {
        List<AgendaPerso> a = aRepository.findAll();

        if(a.isEmpty()){
            throw new IllegalStateException("No agenda");
        }
        return a;
    }
   
    public  List<AgendaPerso> getAllAgendaByPersonnel(String id) {
        List<AgendaPerso> a = aRepository.findByIdPersonnel(id);

        if(a.isEmpty()){
            throw new IllegalStateException("No agenda");
        }
        return a;
    }

    public  AgendaPerso getAgendaPersoById(int id) {
        return aRepository.findById(id).orElseThrow(() -> new IllegalStateException("Agenda non trouvé") );
    }

    public  String deleteAgenda(int id) {
        AgendaPerso a = aRepository.findById(id).orElseThrow(() -> new IllegalStateException("Agenda non trouvé") );

        aRepository.delete(a);

        return "Supprimé avec succèss";
    }
}
