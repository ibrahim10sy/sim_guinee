package sim.guinee.service;

import java.time.LocalDate;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import sim.guinee.model.Produit;
import sim.guinee.repository.ProduitRepository;

@Service
public class ProduitService {
    
    @Autowired
    ProduitRepository pRepository;
    @Autowired
    CodeGenerator codeGenerator;

    public Produit create(Produit p,List<MultipartFile> imageFiles) throws IOException{
         // Traitement des fichiers d'images
        if (imageFiles != null && !imageFiles.isEmpty()) {
              String imageLocation = "/karlo"; 
            // String imageLocation = "C:\\Users\\bane8\\Documents\\Spring Boot App\\Karlo_car\\images";
            Path imageRootLocation = Paths.get(imageLocation);
            if (!Files.exists(imageRootLocation)) {
                Files.createDirectories(imageRootLocation);
            }
    
            List<String> imagePaths = new ArrayList<>();
            for (MultipartFile imageFile : imageFiles) {
                if (!imageFile.isEmpty()) {
                    String imageName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
                    Path imagePath = imageRootLocation.resolve(imageName);
                    try {
                        Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
                        // String onlineImagePath =fileUploade.uploadImageToFTP(imagePath, imageName);
                        imagePaths.add(imageName);
                    } catch (IOException e) {
                        throw new IOException("Erreur lors de la sauvegarde de l'image : " + imageFile.getOriginalFilename(), e);
                    }
                }
            }
            p.setImages(imagePaths);
        }
        String code = codeGenerator.genererCode();
        p.setCodeProduit(code);
        p.setDateEnregistrement(LocalDate.now());
        return pRepository.save(p);
    }

    public Produit updateProduit(Produit p, Long id, List<MultipartFile> imageFiles) throws IOException{
        Produit pr = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune produit trouvé avec id "+id) );

        pr.setNomProduit(p.getNomProduit());
        pr.setFamilleProduit(p.getFamilleProduit());
        pr.setEtat(p.getEtat());
        pr.setModifierLe(LocalDate.now());
        pr.setModifierPar(p.getModifierPar());

         // Traitement des fichiers d'images
         if (imageFiles != null && !imageFiles.isEmpty()) {
            String imageLocation = "/karlo"; 
          // String imageLocation = "C:\\Users\\bane8\\Documents\\Spring Boot App\\Karlo_car\\images";
          Path imageRootLocation = Paths.get(imageLocation);
          if (!Files.exists(imageRootLocation)) {
              Files.createDirectories(imageRootLocation);
          }
  
          List<String> imagePaths = new ArrayList<>();
          for (MultipartFile imageFile : imageFiles) {
              if (!imageFile.isEmpty()) {
                  String imageName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
                  Path imagePath = imageRootLocation.resolve(imageName);
                  try {
                      Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
                      // String onlineImagePath =fileUploade.uploadImageToFTP(imagePath, imageName);
                      imagePaths.add(imageName);
                  } catch (IOException e) {
                      throw new IOException("Erreur lors de la sauvegarde de l'image : " + imageFile.getOriginalFilename(), e);
                  }
              }
          }
          pr.setImages(imagePaths);
      }
        return pRepository.save(pr);
    }

    public Produit getById(Long id){
        return pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune produit trouvé avec id "+id) );
    }

    public List<Produit> getAllProduits(){
        List<Produit> pList = pRepository.findAll();

        if(pList.isEmpty()){
            throw new IllegalStateException("Aucune produit trouvé avec");

        }
        return pList;
    }
    public List<Produit> getAllProduitsByFamille(Long id){
        List<Produit> pList = pRepository.findByFamilleProduit(id);

        if(pList.isEmpty()){
            throw new IllegalStateException("Aucune produit trouvé avec");

        }
        return pList;
    }
  
    public List<Produit> getAllProduitsByIdPersonnel(String id){
        List<Produit> pList = pRepository.findByIdPersonnel(id);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucune produit trouvé avec");

        }
        return pList;
    }
 
    public List<Produit> getAllProduitsByIdMagasin(Long id){
        List<Produit> pList = pRepository.findByIdMagasin(id);
        if(pList.isEmpty()){
            throw new IllegalStateException("Aucune produit trouvé avec");

        }
        return pList;
    }

    public String deleteProduit(Long id){
        Produit p = pRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune produit trouvé avec id "+id) );
        pRepository.delete(p);
        return "Produit supprimé avec succès";
    }
}
