package sim.guinee.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.FormeProduit;
import sim.guinee.service.FormeProduitService;


@RestController
@RequestMapping("api-sim/formeProduit")
public class FormeProduitController {
    
    @Autowired
    FormeProduitService aService;

    @PostMapping("/addFormeProduit")
    @Operation(summary="Création de  Forme Produit ")
    public ResponseEntity<FormeProduit> createFormeProduit(@RequestBody FormeProduit a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<FormeProduit> updateFormeProduit(@PathVariable Long id, @RequestBody FormeProduit a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'une Forme Produit")
    public ResponseEntity<FormeProduit> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @Operation(summary="Récuperation de tout les Forme Produits ")
    public ResponseEntity<List<FormeProduit>> getAllFormeProduit() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }
 
    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'une forme  de produit  l'id ")
    public String deleteFiche(@PathVariable Long id) {
        return aService.deleteFormeProduit(id);
    }
}
