package sim.guinee.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Fournisseur;
import sim.guinee.service.FournisseurService;

@RestController
@RequestMapping("api-sim/fournisseur")
public class FournisseurController {
 
    @Autowired
    FournisseurService aService;

    @PostMapping("/addFournisseur")
    @Operation(summary="Création de compte Fournisseur")
    public ResponseEntity<Fournisseur> create(@RequestBody Fournisseur a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable int id, @RequestBody Fournisseur a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un Fournisseur à travers id")
    public ResponseEntity<Fournisseur> getById(@PathVariable int id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllFournisseur")
    @Operation(summary="Récuperation de tout les fournisseurs")
    public ResponseEntity<List<Fournisseur>> getAllFournisseur() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Fournisseur en  fonction de l'id ")
    public String deleteFournisseur(@PathVariable int id) {
        return aService.deleteFournisseur(id);
    }

}
