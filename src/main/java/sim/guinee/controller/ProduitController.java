package sim.guinee.controller;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import sim.guinee.model.FamilleProduit;
import sim.guinee.model.Personnel;
import sim.guinee.model.Produit;
import sim.guinee.service.ProduitService;

@RestController
@RequestMapping("api-sim/produit")
public class ProduitController {
    
    @Autowired
    ProduitService aService;

    @PostMapping("/create")
    @Operation(summary = "création d'un produit")
    public ResponseEntity<Produit> create(
            @Valid @RequestParam("produit") String produitString,
            @RequestParam(value = "images", required = false) List<MultipartFile> imageFiles
           )
            throws Exception {
                

                Produit per = new Produit();
                try {
                    per = new JsonMapper().readValue(produitString, Produit.class);
                } catch (JsonProcessingException e) {
                    throw new Exception(e.getMessage());
                }
            
                Produit saved = aService.create(per, imageFiles);
                System.out.println(" controller :" + saved);

                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            }
    
    @PutMapping("/update/{id}")
    @Operation(summary = "Modification d'un produit")
    public ResponseEntity<Produit> update(
            @Valid @RequestParam("produit") String produitString,
            @PathVariable Long idProduit,
            @RequestParam(value = "images", required = false) List<MultipartFile> imageFiles
           )
            throws Exception {
                

                Produit per = new Produit();
                try {
                    per = new JsonMapper().readValue(produitString, Produit.class);
                } catch (JsonProcessingException e) {
                    throw new Exception(e.getMessage());
                }
            
                Produit saved = aService.updateProduit(per, idProduit,  imageFiles);
                System.out.println(" controller :" + saved);

                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            }
    
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'une famille de produit")
    public ResponseEntity<Produit> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllProduit")
    @Operation(summary="Récuperation de tout les produit")
    public ResponseEntity<List<Produit>> getAll() {
        return new ResponseEntity<>(aService.getAllProduits(), HttpStatus.OK);
    }
    @GetMapping("/getAllByFamilleProduit/{id}")
    @Operation(summary="Récuperation de tout les produit")
    public ResponseEntity<List<Produit>> getAllFamilleProduit(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getAllProduitsByFamille(id), HttpStatus.OK);
    }

    @GetMapping("/getAllByMagasin/{id}")
    @Operation(summary="Récuperation de tout les produit")
    public ResponseEntity<List<Produit>> getAllByMagasin(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getAllProduitsByIdMagasin(id), HttpStatus.OK);
    }

    @GetMapping("/getAllByPersonnel/{NomPersonnel}")
    @Operation(summary="Récuperation de tout les produit")
    public ResponseEntity<List<Produit>> getAllByPersonnel(@PathVariable String id) {
        return new ResponseEntity<>(aService.getAllProduitsByIdPersonnel(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'une famille de produit  l'id ")
    public String deleteMsg(@PathVariable Long id) {
        return aService.deleteProduit(id);
    }
}
