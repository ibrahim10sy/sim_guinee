package sim.guinee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.TypeDetaillant;
import sim.guinee.repository.TypeDetaillantRepository;

@Service
public class TypeDetaillantService {
    
    @Autowired
    TypeDetaillantRepository tRepository;


    public TypeDetaillant create(TypeDetaillant type){
        type.setDateEnregistrement(LocalDate.now());
        return tRepository.save(type);
    }

    public TypeDetaillant update(TypeDetaillant t , Long id){
        TypeDetaillant type = tRepository.findById(id).orElseThrow(() -> new IllegalStateException("Type detaillant  non trouvé") );

        type.setTypeDetaillant(t.getTypeDetaillant());
        type.setModifierLe(LocalDate.now());
        type.setModifierPar(t.getModifierPar());

        return tRepository.save(type);
    }

    public List<TypeDetaillant> getAll(){
        List<TypeDetaillant> typeList = tRepository.findAll();

        if(typeList.isEmpty()){
             throw new IllegalStateException("Aucun type détaillant trouvé");
        }
        return typeList;
    }

    public String deleteType(Long id){
       TypeDetaillant v  = tRepository.findById(id).orElseThrow(() -> new IllegalStateException("Type detaillant  non trouvé") );
        tRepository.delete(v);
        return "Type  supprimée avec succès";
    }
}
