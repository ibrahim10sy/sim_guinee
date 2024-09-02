package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.PrixMarcheGrossiste;
import sim.guinee.service.PrixMarcheGrossisteService;

@RestController
@RequestMapping("api-sim/prixMarche/grossiste")
public class prixMarcheGrossisteController {
    
    @Autowired
    PrixMarcheGrossisteService aService;

    @PostMapping("/addPrix")
    @Operation(summary="Création de Prix marche grossiste")
    public ResponseEntity<PrixMarcheGrossiste> create(@RequestBody PrixMarcheGrossiste a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<PrixMarcheGrossiste> updatePrixMarcheGrossiste(@PathVariable Long id, @RequestBody PrixMarcheGrossiste a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un PrixMarcheGrossiste à travers id")
    public ResponseEntity<PrixMarcheGrossiste> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllByProduit/{produit}")
    @Operation(summary="Récuperation de tout les prix marche  Produits ")
    public ResponseEntity<List<PrixMarcheGrossiste>> getAllPrixMarcheGrossisteByProduit(@PathVariable String produit) {
        return new ResponseEntity<>(aService.getAllByProduit(produit), HttpStatus.OK);
    }
   
    @GetMapping("/getAllByProduitAndLocaliteVente/{produit}/{localiteVente}")
    @Operation(summary="Récuperation de tout les prix marche  Produits et localite vente ")
    public ResponseEntity<List<PrixMarcheGrossiste>> getAllPrixMarcheGrossisteByProduitAndLoc(@PathVariable String produit , @PathVariable String localiteVente)  {
        return new ResponseEntity<>(aService.getAllByPoduitAndLoc(produit,localiteVente), HttpStatus.OK);
    }
   

    @GetMapping("/getAllByLocaliteVente/{localiteVente}")
    @Operation(summary="Récuperation de tout les prix marche  par localite Vente ")
    public ResponseEntity<List<PrixMarcheGrossiste>> getAllPrixMarcheGrossisteByLocVente(@PathVariable String localiteVente) {
        return new ResponseEntity<>(aService.getAllByLocaliteVente(localiteVente), HttpStatus.OK);
    }
   
    @GetMapping("/getAllByGrossiste/{grossiste}")
    @Operation(summary="Récuperation de tout les prix marche  par grossiste ")
    public ResponseEntity<List<PrixMarcheGrossiste>> getAllPrixMarcheGrossisteByGrossiste(@PathVariable String grossiste) {
        return new ResponseEntity<>(aService.getAllByGrossiste(grossiste), HttpStatus.OK);
    }
   
    @GetMapping("/getAllByLocalite/{localiteAchat}")
    @Operation(summary="Récuperation de tout les prix marche  par localité ")
    public ResponseEntity<List<PrixMarcheGrossiste>> getAllPrixMarcheGrossisteByLoc(@PathVariable String localiteAchat) {
        return new ResponseEntity<>(aService.getAllByLocaliteAchat(localiteAchat), HttpStatus.OK);
    }
   
    @GetMapping("/getAllPrixMarcheGrossiste")
    @Operation(summary="Récuperation de tout les Prix marche grossiste")
    public ResponseEntity<List<PrixMarcheGrossiste>> getAllPrixMarcheGrossiste() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }
   
    @GetMapping("/getAllPrixMarcheGrossisteByTop10")
    @Operation(summary="Récuperation des 10 derniers Prix marche grossiste")
    public ResponseEntity<List<PrixMarcheGrossiste>> getAllPrixMarcheGrossisteTop10() {
        return new ResponseEntity<>(aService.getAllTop10prix(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Pays Produit en  fonction de l'id ")
    public String deletePrixMarcheGrossiste(@PathVariable Long id) {
        return aService.deletePrix(id);
    }
}
