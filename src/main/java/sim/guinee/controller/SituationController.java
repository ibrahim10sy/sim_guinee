package sim.guinee.controller;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Situation;
import sim.guinee.service.SituationService;

@RestController
@RequestMapping("api-sim/situation")
public class SituationController {
    
    @Autowired
    SituationService aService;

    @PostMapping("/addSituation")
    @Operation(summary="Création de Pays Produit")
    public ResponseEntity<Situation> create(@RequestBody Situation a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Situation> updateSituation(@PathVariable Long id, @RequestBody Situation a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un Situation à travers id")
    public ResponseEntity<Situation> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllByDate/{date}")
    @Operation(summary="Récuperation de tout les Situations ")
    public ResponseEntity<List<Situation>> getAllSituationByRegion(@PathVariable LocalDate date) {
        return new ResponseEntity<>(aService.getAllByDate(date), HttpStatus.OK);
    }
   
    @GetMapping("/getAllSituation")
    @Operation(summary="Récuperation de tout les Pays Produits")
    public ResponseEntity<List<Situation>> getAllSituation() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Pays Produit en  fonction de l'id ")
    public String deleteSituation(@PathVariable Long id) {
        return aService.deleteSituation(id);
    }
}
