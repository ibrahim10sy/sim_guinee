package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Parametrage;
import sim.guinee.service.ParametrageService;

@RestController
@RequestMapping("api-sim/parametre")
public class ParametrageController {
    
    @Autowired
    ParametrageService aService;

    @PostMapping("/addParametrage")
    @Operation(summary="Création de Parametrage")
    public ResponseEntity<Parametrage> create(@RequestBody Parametrage a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Parametrage> updateParametrage(@PathVariable Long id, @RequestBody Parametrage a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un Parametrage à travers id")
    public ResponseEntity<Parametrage> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllParametrage")
    @Operation(summary="Récuperation de tout les Parametrages")
    public ResponseEntity<List<Parametrage>> getAllParametrage() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Parametrage en  fonction de l'id ")
    public String deleteParametrage(@PathVariable Long id) {
        return aService.deleteParam(id);
    }
}
