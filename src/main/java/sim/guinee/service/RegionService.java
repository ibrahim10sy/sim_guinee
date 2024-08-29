package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.Region;
import sim.guinee.repository.RegionRepository;

@Service
public class RegionService {
    
    @Autowired
    RegionRepository rRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public Region creer(Region r ){
        Region re = rRepository.findByNomRegion(r.getNomRegion());

        if(re != null){
            throw new IllegalStateException("Cette région existe déjà");
        }

        String code = codeGenerator.genererCode();
        r.setCodeRegion(code);
        r.setDateEnregistrement(LocalDate.now());
        return rRepository.save(r);
    }

    public Region update(Region r, int id){
        Region re = rRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune région trouvé") );

        re.setNomRegion(r.getNomRegion());
        re.setAbregeRegion(r.getAbregeRegion());
        re.setRegionNaturelle(r.getRegionNaturelle());
        re.setCouleur(r.getCouleur());
        re.setPersonnel(r.getPersonnel());
        re.setEtat(r.getEtat());
        re.setModifierPar(r.getModifierPar());
        re.setModifierLe(LocalDate.now());

        return rRepository.save(re);
    }

    public List<Region> getAll(){
        List<Region> rList = rRepository.findAll();

        if(rList.isEmpty()){
            throw new IllegalStateException("Aucune région trouvé");
        }

        return rList;
    }
    public List<Region> getAllByRegionNaturelle(int id){
        List<Region> rList = rRepository.findByRegionNaturelle(id);

        if(rList.isEmpty()){
            throw new IllegalStateException("Aucune région trouvé");
        }

        return rList;
    }

    public String deleteRegion(int id){
        Region r = rRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune région trouvé") );
        rRepository.delete(r);
        return "Supprimée avec succès";
    }
}
