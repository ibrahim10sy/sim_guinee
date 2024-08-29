package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.RegionProduit;
import sim.guinee.repository.RegionProduitRepository;

@Service
public class RegionProduitService {
    
    @Autowired
    RegionProduitRepository rRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public RegionProduit creer(RegionProduit r ){
        RegionProduit re = rRepository.findByNomRegionProduit(r.getNomRegionProduit());

        if(re != null){
            throw new IllegalStateException("Cette région existe déjà");
        }

        String code = codeGenerator.genererCode();
        r.setCodeRegionProduit(code);
        r.setDateEnregistrement(LocalDate.now());
        return rRepository.save(r);
    }

    public RegionProduit update(RegionProduit r, int id){
        RegionProduit re = rRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune région trouvé") );

        re.setNomRegionProduit(r.getNomRegionProduit());
        re.setFormeConcerne(r.getFormeConcerne());
        re.setEtat(r.getEtat());
        re.setModifierPar(r.getModifierPar());
        re.setModifierLe(LocalDate.now());

        return rRepository.save(re);
    }

    public List<RegionProduit> getAll(){
        List<RegionProduit> rList = rRepository.findAll();

        if(rList.isEmpty()){
            throw new IllegalStateException("Aucune région trouvé");
        }

        return rList;
    }

    public String deleteRegionProduit(int id){
        RegionProduit r = rRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune région trouvé") );
        rRepository.delete(r);
        return "Supprimée avec succès";
    }
}
