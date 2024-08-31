package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Region;
import sim.guinee.service.RegionService;

@RestController
@RequestMapping("api-sim/region")
public class RegionController {
    
    @Autowired
    RegionService aService;

    @PostMapping("/addRegion")
    @Operation(summary="Création de region")
    public ResponseEntity<Region> create(@RequestBody Region a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Region> updateRegion(@PathVariable Long id, @RequestBody Region a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getAllByRegionNaturelle/{id}")
    @Operation(summary="Récuperation de tout les Regions ")
    public ResponseEntity<List<Region>> getAllRegionByRegion(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getAllByRegionNaturelle(id), HttpStatus.OK);
    }
   
    @GetMapping("/getAllRegion")
    @Operation(summary="Récuperation de tout les Regions")
    public ResponseEntity<List<Region>> getAllRegion() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Region en  fonction de l'id ")
    public String deleteRegion(@PathVariable Long id) {
        return aService.deleteRegion(id);
    }
}
