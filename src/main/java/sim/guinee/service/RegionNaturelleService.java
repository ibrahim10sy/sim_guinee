package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.RegionNaturelle;
import sim.guinee.repository.RegionNaturelleRepository;

@Service
public class RegionNaturelleService {
    
    @Autowired
    RegionNaturelleRepository rRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public RegionNaturelle creer(RegionNaturelle r ){
        RegionNaturelle re = rRepository.findByNomRegionNaturelle(r.getNomRegionNaturelle());

        if(re != null){
            throw new IllegalStateException("Cette région existe déjà");
        }

        return rRepository.save(r);
    }

    public RegionNaturelle update(RegionNaturelle r, int id){
        RegionNaturelle re = rRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune région trouvé") );

        re.setNomRegionNaturelle(r.getNomRegionNaturelle());
        return rRepository.save(re);
    }

    public List<RegionNaturelle> getAll(){
        List<RegionNaturelle> rList = rRepository.findAll();

        if(rList.isEmpty()){
            throw new IllegalStateException("Aucune région trouvé");
        }

        return rList;
    }

    public String deleteRegionNaturelle(int id){
        RegionNaturelle r = rRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune région trouvé") );
        rRepository.delete(r);
        return "Supprimée avec succès";
    }
}
