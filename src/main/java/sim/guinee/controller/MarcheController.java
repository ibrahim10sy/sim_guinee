package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Marche;
import sim.guinee.service.MarcheService;

@RestController
@RequestMapping("api-sim/marche")
public class MarcheController {
    
    @Autowired
    MarcheService aService;

    @PostMapping("/addMarche")
    @Operation(summary="Création de Marche")
    public ResponseEntity<Marche> create(@RequestBody Marche a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Marche> updateMarche(@PathVariable Long id, @RequestBody Marche a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un Marche à travers id")
    public ResponseEntity<Marche> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllMarche")
    @Operation(summary="Récuperation de tout les Marches")
    public ResponseEntity<List<Marche>> getAllMarche() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Marche en  fonction de l'id ")
    public String deleteMarche(@PathVariable Long id) {
        return aService.deleteMarche(id);
    }

}
