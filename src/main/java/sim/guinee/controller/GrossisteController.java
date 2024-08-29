package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Grossiste;
import sim.guinee.service.GrossisteService;


@RestController
@RequestMapping("api-sim/grossiste")
public class GrossisteController {
    
    @Autowired
    GrossisteService aService;

    @PostMapping("/addGrossiste")
    @Operation(summary="Création de compte Grossiste")
    public ResponseEntity<Grossiste> create(@RequestBody Grossiste a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Grossiste> updateGrossiste(@PathVariable int id, @RequestBody Grossiste a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un Grossiste à travers id")
    public ResponseEntity<Grossiste> getById(@PathVariable int id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllGrossiste")
    @Operation(summary="Récuperation de tout les grossistes")
    public ResponseEntity<List<Grossiste>> getAllGrossiste() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Grossiste en  fonction de l'id ")
    public String deleteGrossiste(@PathVariable int id) {
        return aService.deleteGrossiste(id);
    }
}
