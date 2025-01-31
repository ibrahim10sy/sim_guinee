package sim.guinee.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.Village;
import sim.guinee.repository.VillageRepository;

@Service
public class VillageService {
    
    @Autowired
    VillageRepository vRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public Village create(Village v){
        Village vi = vRepository.findByNomVillage(v.getNomVillage());

        if(vi != null){
            throw new IllegalStateException("Ce Village existe déjà trouvé");
        }

        String code = codeGenerator.genererCode();
        vi.setDateEnregistrement(LocalDateTime.now());
        vi.setCodeVillage(code);
        return vRepository.save(v);
    }


    public Village update(Village v, int id) {
        Village vi = vRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun village  trouvé") );

        vi.setCommune(v.getCommune());
        vi.setNomVillage(v.getNomVillage());
        vi.setAbregeVillage(v.getAbregeVillage());
        vi.setHomme(v.getHomme());
        vi.setFemme(v.getFemme());
        vi.setJeune(v.getJeune());
        vi.setMenage(v.getMenage());
        vi.setEtat(v.getEtat());
        vi.setModifierPar(v.getModifierPar());
        vi.setModifierLe(LocalDate.now());

        return vRepository.save(vi);
    }

    public List<Village> getAll(){
        List<Village> v = vRepository.findAll();
       
        if(v.isEmpty()){
            throw new IllegalStateException("Aucun village trouvé");
        }

        return v;
    }
    public List<Village> getAllByCommune(String nom){
        List<Village> v = vRepository.findByCommune(nom);
       
        if(v.isEmpty()){
            throw new IllegalStateException("Aucun village trouvé");
        }

        return v;
    }

    public String deleteVillage(int idVillage){
       Village v  = vRepository.findById(idVillage).orElseThrow(() -> new IllegalStateException("Village non trouvé") );
        vRepository.delete(v);
        return "Village  supprimée avec succès";
    }
}
