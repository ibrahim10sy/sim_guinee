package sim.guinee.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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
    @Autowired
    SendMessage sendMessage;
    @Autowired
    CodeGenerator codeGenerator;
    @Autowired 
    ConnecterService cService;

    public Personnel create(Personnel p , MultipartFile avatar) throws Exception{
        
        if(p.getContact() != null){
            Personnel per = pRepository.findByContact(p.getContact());
            if (per != null) {
                // Si un Personnel avec le même numéro de téléphone et le même numéro WhatsApp existe déjà
                throw new IllegalArgumentException("Un compte avec le même contact existe déjà");
            }
        }
        
        if(p.getEmail() != null){
            Personnel per = pRepository.findByEmail(p.getEmail());
            if (per != null) {
                // Si un Personnel avec le même numéro de téléphone et le même numéro WhatsApp existe déjà
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
            String code = codeGenerator.genererCode();
            p.setCode(code);
            return pRepository.save(p);
    }

    public Personnel update(Personnel p , Long id, MultipartFile avatar) throws Exception{
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

                    per.setAvatar(imageName);
                } catch (IOException e) {
                    throw new Exception("Erreur lors du traitement du fichier image : " + e.getMessage());
                }
            }
        return pRepository.save(per);
    }

    public List<Personnel> getAll(){
        List<Personnel> pList = pRepository.findAll();

        if(pList.isEmpty()){
            throw new IllegalStateException("Aucun personnel trouvé");
        }

        return pList;
    }
    
    public String deletePersonnel(Long id){
        pRepository.deleteById(id);
        return "Personnel supprimé avec succès";
    }

    public Personnel activer(Long id ){
        Personnel per = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun personnel trouvé") );

        per.setStatut(1);
        return  pRepository.save(per);
    }

    private String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(9999);

        // this will convert any number sequence into 4 character.
        return String.format("%04d", number);
    }
 
    public String sendOtpCodeWhatsApp(String whatsAppActeur) throws Exception {
        Personnel userVerif = pRepository.findByContact(whatsAppActeur);

        if (userVerif == null){
            throw new Exception("Ce numero n'existe pas, verifier  le numero saisi");
        }
        
        String code = getRandomNumberString();
        String msg = "Votre code de vérification  est " + code + " veuillez garder ce code pour vous uniquement si vous n'avez pas demander à changer de mot de passe veuiilez ignorer ce message";
        sendMessage.sendMessages(whatsAppActeur, msg);
        return code;
    }

    public Personnel updatePassWord(Long id, String newPassWord) throws Exception {
        Optional<Personnel> personnelOpt = pRepository.findById(id);
    
        if (personnelOpt.isPresent()) {
            Personnel personnel = personnelOpt.get();
    
            // Hacher le nouveau mot de passe
            String hashedPassword = passwordEncoder.encode(newPassWord);
            personnel.setPass(hashedPassword);
            personnel.setDateModification(LocalDate.now());
    
            return pRepository.save(personnel);
        } else {
            throw new Exception("Personnel non trouvé avec l'ID : " + id);
        }
    }

    public Personnel desactiver(Long id ){
        Personnel per = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucun personnel trouvé") );

        per.setStatut(0);
        return  pRepository.save(per);
    }

     public Personnel connexion(String email, String pass){
        Personnel p = pRepository.findByEmail(email);
        if (p == null || !passwordEncoder.matches(pass, p.getPass())) {
            throw new EntityNotFoundException("Email ou mot de passe incorrect");
        }
        
        if(p.getStatut()== 0){
            throw new NoContentException("Connexion échoué votre compte  est desactivé \n veuillez contacter l'administrateur pour la procedure d'activation de votre compte !");
        }
        cService.create(p);
        return p;
        }
}
