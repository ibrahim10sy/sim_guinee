package sim.guinee.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.UniteMesure;
import sim.guinee.service.UniteService;

@RestController
@RequestMapping("api-sim/unite")
public class UniteController {
    
    @Autowired
    UniteService aService;

    @PostMapping("/addUniteMesure")
    @Operation(summary="Création d' Unite de Mesure ")
    public ResponseEntity<UniteMesure> create(@RequestBody UniteMesure a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<UniteMesure> updateUniteMesure(@PathVariable Long id, @RequestBody UniteMesure a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un UniteMesure à travers id")
    public ResponseEntity<UniteMesure> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

 
    @GetMapping("/getAllUniteMesure")
    @Operation(summary="Récuperation de tout les Unites de Mesures")
    public ResponseEntity<List<UniteMesure>> getAllUniteMesure() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'une Unite de Mesure en fonction de l'id ")
    public String deleteUniteMesure(@PathVariable Long id) {
        return aService.deleteUniteMesure(id);
    }
}
