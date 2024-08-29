package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.PrixMarcheConsommation;
import sim.guinee.service.PrixMarcheConsoService;

@RestController
@RequestMapping("api-sim/prixMarche/consommation")
public class PrixMarcheConsoController {
    
    @Autowired
    PrixMarcheConsoService aService;

    @PostMapping("/addPrix")
    @Operation(summary="Création de Prix marche collecte")
    public ResponseEntity<PrixMarcheConsommation> create(@RequestBody PrixMarcheConsommation a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<PrixMarcheConsommation> updatePrixMarcheConsommation(@PathVariable int id, @RequestBody PrixMarcheConsommation a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un PrixMarcheConsommation à travers id")
    public ResponseEntity<PrixMarcheConsommation> getById(@PathVariable int id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllByProduit/{nomProduit}")
    @Operation(summary="Récuperation de tout les prix marche  Produits ")
    public ResponseEntity<List<PrixMarcheConsommation>> getAllPrixMarcheConsommationByProduit(@PathVariable String nom) {
        return new ResponseEntity<>(aService.getAllByProduit(nom), HttpStatus.OK);
    }
   
   
    @GetMapping("/getAllPrixMarcheConsommation")
    @Operation(summary="Récuperation de tout les Prix marche collecte")
    public ResponseEntity<List<PrixMarcheConsommation>> getAllPrixMarcheConsommation() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Pays Produit en  fonction de l'id ")
    public String deletePrixMarcheConsommation(@PathVariable int id) {
        return aService.deletePrix(id);
    }
}
