package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Prefecture;
import sim.guinee.service.PrefectureService;

@RestController
@RequestMapping("api-sim/prefecture")
public class PrefectureController {
    
    @Autowired
    PrefectureService aService;

    @PostMapping("/addPrefecture")
    @Operation(summary="Création de Pays Produit")
    public ResponseEntity<Prefecture> create(@RequestBody Prefecture a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Prefecture> updatePrefecture(@PathVariable Long id, @RequestBody Prefecture a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un Prefecture à travers id")
    public ResponseEntity<Prefecture> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllByRegion/{id}")
    @Operation(summary="Récuperation de tout les prefectures ")
    public ResponseEntity<List<Prefecture>> getAllPrefectureByRegion(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getAllByRegion(id), HttpStatus.OK);
    }
   
    @GetMapping("/getAllPrefecture")
    @Operation(summary="Récuperation de tout les Prefectures")
    public ResponseEntity<List<Prefecture>> getAllPrefecture() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un prefecture en  fonction de l'id ")
    public String deletePrefecture(@PathVariable Long id) {
        return aService.deletePrefecture(id);
    }
}
