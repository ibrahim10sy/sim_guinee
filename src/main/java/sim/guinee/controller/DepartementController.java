package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Departement;
import sim.guinee.service.DepartementService;


@RestController
@RequestMapping("api-sim/departement")
public class DepartementController {
    
    @Autowired
    DepartementService aService;

    @PostMapping("/addDepartement")
    @Operation(summary="Création de Departement")
    public ResponseEntity<Departement> create(@RequestBody Departement a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Departement> updateDepartement(@PathVariable Long id, @RequestBody Departement a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getDepartementByRegion/{region}")
    @Operation(summary="Récuperation de tout les  Departements par region")
    public ResponseEntity<List<Departement>>  getByDepartement(@PathVariable int region) {
        return new ResponseEntity<>(aService.getAllByRegion(region), HttpStatus.OK);
    }

    @GetMapping("/getAllDepartement")
    @Operation(summary="Récuperation de tout les departements")
    public ResponseEntity<List<Departement>> getAllDepartement() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'une Departement  en  fonction de l'id ")
    public String deleteDepartement(@PathVariable Long id) {
        return aService.deleteDepartement(id);
    }
}
