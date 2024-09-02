package sim.guinee.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.UniteMesure;
import sim.guinee.repository.UniteMesureRepository;

@Service
public class UniteService {
    
    @Autowired
    UniteMesureRepository vRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public UniteMesure create(UniteMesure v){
        UniteMesure vi = vRepository.findByNomUnite(v.getNomUnite());

        if(vi != null){
            throw new IllegalStateException("Cet Unite de mesure existe déjà trouvé");
        }

        v.setDateEnregistrement(LocalDate.now());
    
        return vRepository.save(v);
    }


    public UniteMesure update(UniteMesure v, Long id) {
        UniteMesure vi = vRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun UniteMesure  trouvé") );

        vi.setNomUnite(v.getNomUnite());
        vi.setDefinition(v.getDefinition());
        vi.setPoidsIndicatif(v.getPoidsIndicatif());
        vi.setModifierPar(v.getModifierPar());
        vi.setModifierLe(LocalDate.now());

        return vRepository.save(vi);
    }

    public List<UniteMesure> getAll(){
        List<UniteMesure> v = vRepository.findAll();
       
        if(v.isEmpty()){
            throw new IllegalStateException("Aucun Unite Mesure trouvé");
        }

        return v;
    }
    
   

    public UniteMesure getById(Long id){
        UniteMesure sous = vRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune sous prefecture trouvé") );
        return sous;

    }

    public String deleteUniteMesure(Long idUniteMesure){
       UniteMesure v  = vRepository.findById(idUniteMesure).orElseThrow(() -> new IllegalStateException("UniteMesure non trouvé") );
        vRepository.delete(v);
        return "Unite supprimée avec succès";
    }
}
