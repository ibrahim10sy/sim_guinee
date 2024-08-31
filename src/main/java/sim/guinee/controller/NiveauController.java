package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.NiveauApprovisionement;
import sim.guinee.service.NiveauService;

@RestController
@RequestMapping("api-sim/niveauApprovisionement")
public class NiveauController {
    
    @Autowired
    NiveauService aService;

    @PostMapping("/addNiveau")
    @Operation(summary="Création de Niveau d'approvisionement")
    public ResponseEntity<NiveauApprovisionement> create(@RequestBody NiveauApprovisionement a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<NiveauApprovisionement> updateNiveauApprovisionement(@PathVariable Long id, @RequestBody NiveauApprovisionement a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un NiveauApprovisionement à travers id")
    public ResponseEntity<NiveauApprovisionement> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllNiveauApprovisionement")
    @Operation(summary="Récuperation de tout les NiveauApprovisionements")
    public ResponseEntity<List<NiveauApprovisionement>> getAllNiveauApprovisionement() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un NiveauApprovisionement en  fonction de l'id ")
    public String deleteNiveauApprovisionement(@PathVariable Long id) {
        return aService.deleteNiveau(id);
    }
}
