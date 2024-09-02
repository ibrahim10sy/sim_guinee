package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.EnqueteCollecte;
import sim.guinee.model.EnqueteConsommation;
import sim.guinee.service.EnqueteCollecteService;


@RestController
@RequestMapping("api-sim/enquete/collecte")
public class EnqueteCollecteController {
    
    @Autowired
    EnqueteCollecteService aService;

    @PostMapping("/addEnqueteCollecte")
    @Operation(summary="Création de Enquete Collecte")
    public ResponseEntity<EnqueteCollecte> create(@RequestBody EnqueteCollecte a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<EnqueteCollecte> updateEnqueteCollecte(@PathVariable Long id, @RequestBody EnqueteCollecte a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getAllEnqueteCollecte")
    @Operation(summary="Récuperation de tout les Enquetes Collectes")
    public ResponseEntity<List<EnqueteCollecte>> getAllEnqueteCollecte() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    
    @GetMapping("/getAllEnqueteCollecteByTop10")
    @Operation(summary="Récuperation des 10 derniers enquetes collecte")
    public ResponseEntity<List<EnqueteCollecte>> getAllPrixMarcheGrossisteTop10() {
        return new ResponseEntity<>(aService.getAllTop10prix(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'une enquete collecte  à travers id")
    public ResponseEntity<EnqueteCollecte> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé une Enquete Collecte  en  fonction de l'id ")
    public String deleteEnqueteCollecte(@PathVariable Long id) {
        return aService.deleteEnqueteCollecte(id);
    }
}
