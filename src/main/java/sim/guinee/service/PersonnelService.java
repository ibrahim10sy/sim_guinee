package sim.guinee.service;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityNotFoundException;
import sim.guinee.exception.NoContentException;
import sim.guinee.model.Personnel;
import sim.guinee.repository.PersonnelRepository;

@Service
public class PersonnelService {
    
    @Autowired
    PersonnelRepository pRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public Personnel create(Personnel p , MultipartFile avatar) throws Exception{
        
        if(p.getContact() != null){
            Personnel per = pRepository.findByContact(p.getContact());
            if (per != null) {
                // Si un acteur avec le même numéro de téléphone et le même numéro WhatsApp existe déjà
                throw new IllegalArgumentException("Un compte avec le même contact existe déjà");
            }
        }
        
        if(p.getEmail() != null){
            Personnel per = pRepository.findByEmail(p.getEmail());
            if (per != null) {
                // Si un acteur avec le même numéro de téléphone et le même numéro WhatsApp existe déjà
                throw new IllegalArgumentException("Un compte avec le même email existe déjà");
            }
        }

         if (avatar != null) {
            String imageLocation = "/sim";
                try {
                    Path imageRootLocation = Paths.get(imageLocation);
                    if (!Files.exists(imageRootLocation)) {
                        Files.createDirectories(imageRootLocation);
                    }
                    String imageName = UUID.randomUUID().toString() + "_" + avatar.getOriginalFilename();
                    Path imagePath = imageRootLocation.resolve(imageName);
                    Files.copy(avatar.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
                    // String onlineImagePath =fileUploade.uploadImageToFTP(imagePath, imageName);

                    p.setAvatar(imageName);
                } catch (IOException e) {
                    throw new Exception("Erreur lors du traitement du fichier image : " + e.getMessage());
                }
            }
            p.setDateEnregistrement(LocalDate.now());
            //On hashe le mot de passe
            String passWordHasher = passwordEncoder.encode(p.getPass());
            p.setPass(passWordHasher);

            return pRepository.save(p);
    }

    public Personnel update(Personnel p , int id, MultipartFile avatar) throws Exception{
        Personnel per = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun personnel trouvé") );

        per.setTitre(p.getTitre());
        per.setNom(p.getNom());
        per.setPrenom(p.getPrenom());
        per.setContact(p.getContact());
        per.setEmail(p.getEmail());
        per.setFonction(p.getFonction());
        per.setDescriptionFonction(p.getDescriptionFonction());
        per.setNiveau(p.getNiveau());
        per.setStatut(p.getStatut());
        per.setDateModification(LocalDate.now());

        if (avatar != null) {
            String imageLocation = "/sim";
                try {
                    Path imageRootLocation = Paths.get(imageLocation);
                    if (!Files.exists(imageRootLocation)) {
                        Files.createDirectories(imageRootLocation);
                    }
                    String imageName = UUID.randomUUID().toString() + "_" + avatar.getOriginalFilename();
                    Path imagePath = imageRootLocation.resolve(imageName);
                    Files.copy(avatar.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
                    // String onlineImagePath =fileUploade.uploadImageToFTP(imagePath, imageName);

                    p.setAvatar(imageName);
                } catch (IOException e) {
                    throw new Exception("Erreur lors du traitement du fichier image : " + e.getMessage());
                }
            }
        return pRepository.save(per);
    }

    public List<Personnel> getAlll(){
        List<Personnel> pList = pRepository.findAll();

        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun personnel trouvé");
        }

        return pList;
    }
    
    public String deletePersonnel(int id){
        pRepository.deleteById(id);
        return "Personnel supprimé avec succès";
    }

    //  public Acteur connexionActeur(String emailActeur, String password){
    //     Acteur acteur = acteurRepository.findByEmailActeur(emailActeur);
    //     if (acteur == null || !passwordEncoder.matches(password, acteur.getPassword())) {
    //         throw new EntityNotFoundException("Email ou mot de passe incorrect");
    //     }
        
    //     if(acteur.getStatutActeur()==false){
    //         throw new NoContentException("Connexion échoué votre compte  est desactivé \n veuillez contacter l'administrateur pour la procedure d'activation de votre compte !");
    //     }
    //     return acteur;
    //     }
}
