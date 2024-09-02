package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.PrixMarcheConsommation;
import sim.guinee.model.PrixMarcheGrossiste;
import sim.guinee.service.PrixMarcheConsoService;

@RestController
@RequestMapping("api-sim/prixMarche/consommation")
public class PrixMarcheConsoController {
    
    @Autowired
    PrixMarcheConsoService aService;

    @PostMapping("/addPrix")
    @Operation(summary="Création de Prix marche consommation")
    public ResponseEntity<PrixMarcheConsommation> create(@RequestBody PrixMarcheConsommation a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<PrixMarcheConsommation> updatePrixMarcheConsommation(@PathVariable Long id, @RequestBody PrixMarcheConsommation a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un PrixMarcheConsommation à travers id")
    public ResponseEntity<PrixMarcheConsommation> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllByProduit/{produit}")
    @Operation(summary="Récuperation de tout les prix marche  Produits ")
    public ResponseEntity<List<PrixMarcheConsommation>> getAllPrixMarcheConsommationByProduit(@PathVariable String produit) {
        return new ResponseEntity<>(aService.getAllByProduit(produit), HttpStatus.OK);
    }
   
   
    @GetMapping("/getAllPrixMarcheConsommation")
    @Operation(summary="Récuperation de tout les Prix marche consommation")
    public ResponseEntity<List<PrixMarcheConsommation>> getAllPrixMarcheConsommation() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllPrixMarcheConsoByTop10")
    @Operation(summary="Récuperation des 10 derniers Prix marche consommation")
    public ResponseEntity<List<PrixMarcheConsommation>> getAllPrixMarcheGrossisteTop10() {
        return new ResponseEntity<>(aService.getAllTop10prix(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un consommation en  fonction de l'id ")
    public String deletePrixMarcheConsommation(@PathVariable Long id) {
        return aService.deletePrix(id);
    }
}
