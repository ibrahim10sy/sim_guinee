package sim.guinee.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Fonction;
import sim.guinee.service.FonctionService;


@RestController
@RequestMapping("api-sim/fonction")
public class FonctionController {
    
    @Autowired
    FonctionService aService;

    @PostMapping("/addFonction")
    @Operation(summary="Création de  Fonction ")
    public ResponseEntity<Fonction> createFonction(@RequestBody Fonction a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Fonction> updateFonction(@PathVariable Long id, @RequestBody Fonction a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'une fonction")
    public ResponseEntity<Fonction> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @Operation(summary="Récuperation de tout les fonctions ")
    public ResponseEntity<List<Fonction>> getAllFonction() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }
 
    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'une famille de produit  l'id ")
    public String deleteFiche(@PathVariable Long id) {
        return aService.deleteFonction(id);
    }

}
