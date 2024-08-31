package sim.guinee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Enqueteur;
import sim.guinee.service.EnqueteurService;

@RestController
@RequestMapping("api-sim/enqueteur")
public class EnqueteurController {
 
    @Autowired
    EnqueteurService aService;

    @PostMapping("/addEnqueteur")
    @Operation(summary="Création de compte Enqueteur")
    public ResponseEntity<Enqueteur> create(@RequestBody Enqueteur a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Enqueteur> updateEnqueteur(@PathVariable Long id, @RequestBody Enqueteur a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un Enqueteur à travers id")
    public ResponseEntity<Enqueteur> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllEnqueteur")
    @Operation(summary="Récuperation de tout les enqueteurs")
    public ResponseEntity<List<Enqueteur>> getAllEnqueteur() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Enqueteur en  fonction de l'id ")
    public String deleteEnqueteur(@PathVariable Long id) {
        return aService.deleteEnqueteur(id);
    }
}
