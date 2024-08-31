package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.PaysProduit;
import sim.guinee.service.PaysProduitService;

@RestController
@RequestMapping("api-sim/paysProduit")
public class PaysProduitController {
 
     @Autowired
    PaysProduitService aService;

    @PostMapping("/addPays")
    @Operation(summary="Création de Pays Produit")
    public ResponseEntity<PaysProduit> create(@RequestBody PaysProduit a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<PaysProduit> updatePaysProduit(@PathVariable Long id, @RequestBody PaysProduit a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un PaysProduit à travers id")
    public ResponseEntity<PaysProduit> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllByRegion/{regionProduit}")
    @Operation(summary="Récuperation de tout les Pays Produits par region ")
    public ResponseEntity<List<PaysProduit>> getAllPaysProduitByRegion(@PathVariable String regionProduit) {
        return new ResponseEntity<>(aService.getByRegion(regionProduit), HttpStatus.OK);
    }
   
    @GetMapping("/getAllPaysProduit")
    @Operation(summary="Récuperation de tout les Pays Produits")
    public ResponseEntity<List<PaysProduit>> getAllPaysProduit() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Pays Produit en  fonction de l'id ")
    public String deletePaysProduit(@PathVariable Long id) {
        return aService.delete(id);
    }
}
