package sim.guinee.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.Commune;
import sim.guinee.repository.CommuneRepository;

@Service
public class CommuneService {
    
    @Autowired
    CommuneRepository vRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public Commune create(Commune v){
        Commune vi = vRepository.findByNomCommune(v.getNomCommune());

        if(vi != null){
            throw new IllegalStateException("Ce Commune existe déjà trouvé");
        }

        String code = codeGenerator.genererCode();
        vi.setDateEnregistrement(LocalDateTime.now());
        vi.setCodeCommune(code);
        return vRepository.save(v);
    }


    public Commune update(Commune v, int id) {
        Commune vi = vRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun Commune  trouvé") );

        vi.setDepartement(v.getDepartement());
        vi.setNomCommune(v.getNomCommune());
        vi.setAbregeCommune(v.getAbregeCommune());
        vi.setEtat(v.getEtat());
        vi.setModifierPar(v.getModifierPar());
        vi.setModifierLe(LocalDate.now());

        return vRepository.save(vi);
    }

    public List<Commune> getAll(){
        List<Commune> v = vRepository.findAll();
       
        if(v.isEmpty()){
            throw new IllegalStateException("Aucun Commune trouvé");
        }

        return v;
    }

    public List<Commune> getAllByDepartement(String nom){
        List<Commune> v = vRepository.findByDepartement(nom);
       
        if(v.isEmpty()){
            throw new IllegalStateException("Aucun Commune trouvé");
        }

        return v;
    }

    public String deleteCommune(int idCommune){
       Commune v  = vRepository.findById(idCommune).orElseThrow(() -> new IllegalStateException("Commune non trouvé") );
        vRepository.delete(v);
        return "Commune  supprimée avec succès";
    }
}
