package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.RegionNaturelle;
import sim.guinee.service.RegionNaturelleService;

@RestController
@RequestMapping("api-sim/RegionNaturelle")
public class RegionNaturelleController {
    
    @Autowired
    RegionNaturelleService aService;

    @PostMapping("/addRegion")
    @Operation(summary="Création de RegionNaturelle")
    public ResponseEntity<RegionNaturelle> create(@RequestBody RegionNaturelle a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<RegionNaturelle> updateRegionNaturelle(@PathVariable Long id, @RequestBody RegionNaturelle a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
   
    @GetMapping("/getAllRegionNaturelle")
    @Operation(summary="Récuperation de tout les RegionNaturelles")
    public ResponseEntity<List<RegionNaturelle>> getAllRegionNaturelle() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un RegionNaturelle en  fonction de l'id ")
    public String deleteRegionNaturelle(@PathVariable Long id) {
        return aService.deleteRegionNaturelle(id);
    }
}
