package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.RegionProduit;
import sim.guinee.service.RegionProduitService;

@RestController
@RequestMapping("api-sim/RegionProduit")
public class RegionProduitController {
    
    @Autowired
    RegionProduitService aService;

    @PostMapping("/addRegion")
    @Operation(summary="Création de RegionProduit")
    public ResponseEntity<RegionProduit> create(@RequestBody RegionProduit a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<RegionProduit> updateRegionProduit(@PathVariable Long id, @RequestBody RegionProduit a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
   
    @GetMapping("/getAllRegionProduit")
    @Operation(summary="Récuperation de tout les RegionProduits")
    public ResponseEntity<List<RegionProduit>> getAllRegionProduit() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un RegionProduit en  fonction de l'id ")
    public String deleteRegionProduit(@PathVariable Long id) {
        return aService.deleteRegionProduit(id);
    }
}
