package sim.guinee.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.FicheCollecte;
import sim.guinee.service.FicheCollecteService;

@RestController
@RequestMapping("api-sim/ficheCollecte")
public class FicheCollecteController {
    
    @Autowired
    FicheCollecteService aService;

    @PostMapping("/addFicheCollecte")
    @Operation(summary="Création de  fiche de collecte  ")
    public ResponseEntity<FicheCollecte> createFamille(@RequestBody FicheCollecte a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<FicheCollecte> updateFiche(@PathVariable Long id, @RequestBody FicheCollecte a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'une fiche de collecte")
    public ResponseEntity<FicheCollecte> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @Operation(summary="Récuperation de tout les fiches de collecte")
    public ResponseEntity<List<FicheCollecte>> getAllFicheCollecte() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }
   
    @GetMapping("/getAllByEnquete/{id}")
    @Operation(summary="Récuperation de tout les fiches de collecte en fonction de l'id enquete")
    public ResponseEntity<List<FicheCollecte>> getAllFicheCollecteByEnquete(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getAllByEnquete(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'une fiche de collecte  l'id ")
    public String deleteFiche(@PathVariable Long id) {
        return aService.delete(id);
    }

}
