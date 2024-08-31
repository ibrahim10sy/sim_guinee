package sim.guinee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.CategorieProduit;
import sim.guinee.service.CategorieProduitService;

@RestController
@RequestMapping("api-sim/categorieProduit")
public class CategorieController {
    
    @Autowired
    CategorieProduitService categorieService;

    @PostMapping("/addCategorie")
    @Operation(summary="Création de categorie de produit")
    public ResponseEntity<CategorieProduit> createCategories(@RequestBody CategorieProduit categorieProduit) {
        return new ResponseEntity<>(categorieService.create(categorieProduit), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification de categorie de produit à travers son id")
    public ResponseEntity<CategorieProduit> updateCategories(@PathVariable Long id, @RequestBody CategorieProduit categorieProduit) {
        return new ResponseEntity<>(categorieService.update(categorieProduit, id), HttpStatus.OK);
    }

    @GetMapping("/allCategorie")
    @Operation(summary="Récuperation de tout les catégories de categorie de produit")
    public ResponseEntity<List<CategorieProduit>> getAll() {
        return new ResponseEntity<>(categorieService.getAll(), HttpStatus.OK);
    }
  
    @GetMapping("/allByFamilleProduit/{nomFamille}")
    @Operation(summary="Récuperation de tout les catégories ")
    public ResponseEntity<List<CategorieProduit>> getAllByFamille(@PathVariable String familleProduit) {
        return new ResponseEntity<>(categorieService.getAllByFamilleProduit(familleProduit), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé de catégories de produit en fonction de l'id ")
    public String deleteFilieres(@PathVariable Long id) {
        return categorieService.deleteCategorieProduit(id);
    }

}
