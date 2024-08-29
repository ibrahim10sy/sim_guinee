package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Commune;
import sim.guinee.service.CommuneService;


@RestController
@RequestMapping("api-sim/commune")
public class CommuneController {
     
    @Autowired
    CommuneService aService;

      @PostMapping("/addCommune")
    @Operation(summary="Création de Commune")
    public ResponseEntity<Commune> create(@RequestBody Commune a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Commune> updateCommune(@PathVariable int id, @RequestBody Commune a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getCommuneByDepartement/{nomDepartement}")
    @Operation(summary="Récuperation de tout les  Communes par departement")
    public ResponseEntity<List<Commune>>  getByDepartement(@PathVariable String nom) {
        return new ResponseEntity<>(aService.getAllByDepartement(nom), HttpStatus.OK);
    }

    @GetMapping("/getAllCommune")
    @Operation(summary="Récuperation de tout les communes")
    public ResponseEntity<List<Commune>> getAllCommune() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'une commune  en  fonction de l'id ")
    public String deleteCommune(@PathVariable int id) {
        return aService.deleteCommune(id);
    }
}
