package sim.guinee.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.RucheSync;
import sim.guinee.service.RucheSyncService;

@RestController
@RequestMapping("api-sim/rucheSync")
public class RucheSyncController {
    
    @Autowired
    RucheSyncService aService;

    @PostMapping("/addRucheSync")
    @Operation(summary="Création de Pays Produit")
    public ResponseEntity<RucheSync> create(@RequestBody RucheSync a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<RucheSync> updateRucheSync(@PathVariable Long id, @RequestBody RucheSync a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getAllRucheSync")
    @Operation(summary="Récuperation de tout les Pays Produits")
    public ResponseEntity<List<RucheSync>> getAllRucheSync() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Pays Produit en  fonction de l'id ")
    public String deleteRucheSync(@PathVariable Long id) {
        return aService.deleteRuche(id);
    }
}
