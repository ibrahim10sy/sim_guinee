package sim.guinee.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sim.guinee.model.UserAccess;
import sim.guinee.model.Village;
import sim.guinee.repository.UserAccessRepository;

@Service
public class UserAccessService {
    
    @Autowired
    CodeGenerator codeGenerator;
    @Autowired
    UserAccessRepository userRepository;

    public UserAccess create(UserAccess user){
        user.setDateEnregistrement(LocalDate.now());
        return userRepository.save(user);
    }
    
    public UserAccess update(UserAccess user , int id ){
        UserAccess u = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun access  trouvé") );

        u.setPageEdit(user.getPageEdit());
        u.setPageVerif(user.getPageVerif());
        u.setPageValid(user.getPageValid());
        u.setPageInterd(user.getPageInterd());
        u.setPersonnel(user.getPersonnel());
        u.setDateModification(LocalDate.now());

        return userRepository.save(u);
    }

    public List<UserAccess> getAll(){
        List<UserAccess> accessList = userRepository.findAll();

        if(accessList.isEmpty()){
            throw new IllegalStateException("Liste access user vide ");
        }
        return accessList;
    }

    public String deleteAccess(int id){
       UserAccess u = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("Access non trouvé") );
        userRepository.delete(u);
        return "User access supprimée avec succès";
    }
}
