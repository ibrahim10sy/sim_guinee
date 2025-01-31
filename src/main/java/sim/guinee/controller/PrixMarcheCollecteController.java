package sim.guinee.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.PrixMarcheCollecte;
import sim.guinee.service.PrixMarcheCollecteService;

@RestController
@RequestMapping("api-sim/prixMarche/collecte")
public class PrixMarcheCollecteController {
    
    @Autowired
    PrixMarcheCollecteService aService;

    @PostMapping("/addPrix")
    @Operation(summary="Création de Prix marche collecte")
    public ResponseEntity<PrixMarcheCollecte> create(@RequestBody PrixMarcheCollecte a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<PrixMarcheCollecte> updatePrixMarcheCollecte(@PathVariable int id, @RequestBody PrixMarcheCollecte a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un PrixMarcheCollecte à travers id")
    public ResponseEntity<PrixMarcheCollecte> getById(@PathVariable int id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllByProduit/{nomProduit}")
    @Operation(summary="Récuperation de tout les prix marche  Produits ")
    public ResponseEntity<List<PrixMarcheCollecte>> getAllPrixMarcheCollecteByProduit(@PathVariable String nom) {
        return new ResponseEntity<>(aService.getAllByProduit(nom), HttpStatus.OK);
    }
   

    @GetMapping("/getAllByGrossiste/{nomGrossiste}")
    @Operation(summary="Récuperation de tout les prix marche  par grossiste ")
    public ResponseEntity<List<PrixMarcheCollecte>> getAllPrixMarcheCollecteByGrossiste(@PathVariable String nom) {
        return new ResponseEntity<>(aService.getAllByGrossiste(nom), HttpStatus.OK);
    }
   
    @GetMapping("/getAllPrixMarcheCollecte")
    @Operation(summary="Récuperation de tout les Prix marche collecte")
    public ResponseEntity<List<PrixMarcheCollecte>> getAllPrixMarcheCollecte() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Pays Produit en  fonction de l'id ")
    public String deletePrixMarcheCollecte(@PathVariable int id) {
        return aService.deletePrix(id);
    }
}
