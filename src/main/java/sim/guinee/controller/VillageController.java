package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Village;
import sim.guinee.service.VillageService;

@RestController
@RequestMapping("api-sim/village")
public class VillageController {
    
    @Autowired
    VillageService aService;

    @PostMapping("/addVillage")
    @Operation(summary="Création de village ")
    public ResponseEntity<Village> create(@RequestBody Village a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Village> updateVillage(@PathVariable Long id, @RequestBody Village a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un Village à travers id")
    public ResponseEntity<Village> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllByCommune/{id}")
    @Operation(summary="Récuperation de tout les Villages ")
    public ResponseEntity<List<Village>> getAllVillageByCommune(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getAllByCommune(id), HttpStatus.OK);
    }
   
    @GetMapping("/getAllVillage")
    @Operation(summary="Récuperation de tout les villages")
    public ResponseEntity<List<Village>> getAllVillage() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un village en fonction de l'id ")
    public String deleteVillage(@PathVariable Long id) {
        return aService.deleteVillage(id);
    }
}
