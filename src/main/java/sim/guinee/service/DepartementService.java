package sim.guinee.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.Departement;
import sim.guinee.repository.DepartementRepository;

@Service
public class DepartementService {
    
    @Autowired
    DepartementRepository vRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public Departement create(Departement v){
        Departement vi = vRepository.findByNomDepartement(v.getNomDepartement());

        if(vi != null){
            throw new IllegalStateException("Ce Departement existe déjà trouvé");
        }

        String code = codeGenerator.genererCode();
        v.setDateEnregistrement(LocalDateTime.now());
        v.setCodeDepartement(code);
        return vRepository.save(v);
    }


    public Departement update(Departement v, Long id) {
        Departement vi = vRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun Departement  trouvé") );

        vi.setRegion(v.getRegion());
        vi.setNomDepartement(v.getNomDepartement());
        vi.setAbregeDepartement(v.getAbregeDepartement());
        vi.setEtat(v.getEtat());
        vi.setModifierPar(v.getModifierPar());
        vi.setModifierLe(LocalDate.now());

        return vRepository.save(vi);
    }

    public List<Departement> getAll(){
        List<Departement> v = vRepository.findAll();
       
        if(v.isEmpty()){
            throw new IllegalStateException("Aucun Departement trouvé");
        }

        return v;
    }

    public List<Departement> getAllByRegion(int region){
        List<Departement> v = vRepository.findByRegion(region);
       
        if(v.isEmpty()){
            throw new IllegalStateException("Aucun Departement trouvé");
        }

        return v;
    }

    public String deleteDepartement(Long idDepartement){
       Departement v  = vRepository.findById(idDepartement).orElseThrow(() -> new IllegalStateException("Departement non trouvé") );
        vRepository.delete(v);
        return "Departement  supprimée avec succès";
    }
}
