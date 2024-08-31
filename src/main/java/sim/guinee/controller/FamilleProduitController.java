package sim.guinee.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.FamilleProduit;
import sim.guinee.service.FamilleService;

@RestController
@RequestMapping("api-sim/familleProduit")
public class FamilleProduitController {
    
    @Autowired
    FamilleService aService;

    @PostMapping("/addFamilleProduit")
    @Operation(summary="Création de  Famille Produit  ")
    public ResponseEntity<FamilleProduit> createFamille(@RequestBody FamilleProduit a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<FamilleProduit> updateFamille(@PathVariable Long id, @RequestBody FamilleProduit a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'une famille de produit")
    public ResponseEntity<FamilleProduit> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @Operation(summary="Récuperation de tout les famille de produit")
    public ResponseEntity<List<FamilleProduit>> getAllFamilleProduit() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'une famille de produit  l'id ")
    public String deleteMsg(@PathVariable Long id) {
        return aService.deleteFamilleProduit(id);
    }

}
