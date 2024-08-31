package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.SousPrefecture;
import sim.guinee.service.SousPrefectureService;

@RestController
@RequestMapping("api-sim/SousSousPrefecture")
public class SousSousPrefectureController {
    
    @Autowired
    SousPrefectureService aService;

    @PostMapping("/addSousPrefecture")
    @Operation(summary="Création de Pays Produit")
    public ResponseEntity<SousPrefecture> create(@RequestBody SousPrefecture a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<SousPrefecture> updateSousPrefecture(@PathVariable Long id, @RequestBody SousPrefecture a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un SousPrefecture à travers id")
    public ResponseEntity<SousPrefecture> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllByPrefecture/{id}")
    @Operation(summary="Récuperation de tout les sous prefectures ")
    public ResponseEntity<List<SousPrefecture>> getAllSousPrefectureByPrefecture(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getAllByIdPrefecture(id), HttpStatus.OK);
    }
   
    @GetMapping("/getAllSousPrefecture")
    @Operation(summary="Récuperation de tout les Pays Produits")
    public ResponseEntity<List<SousPrefecture>> getAllSousPrefecture() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Pays Produit en  fonction de l'id ")
    public String deleteSousPrefecture(@PathVariable Long id) {
        return aService.deleteSousPrefecture(id);
    }
}
