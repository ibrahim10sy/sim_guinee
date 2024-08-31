package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.TypeDetaillant;
import sim.guinee.service.TypeDetaillantService;

@RestController
@RequestMapping("api-sim/typeDetaillant")
public class TypeDetaillantController {
 
     @Autowired
    TypeDetaillantService aService;

    @PostMapping("/addTypeDetaillant")
    @Operation(summary="Création de type detaillant")
    public ResponseEntity<TypeDetaillant> create(@RequestBody TypeDetaillant a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<TypeDetaillant> updateTypeDetaillant(@PathVariable Long id, @RequestBody TypeDetaillant a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getAllTypeDetaillant")
    @Operation(summary="Récuperation de tout les types detaillant")
    public ResponseEntity<List<TypeDetaillant>> getAllTypeDetaillant() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un type en  fonction de l'id ")
    public String deleteTypeDetaillant(@PathVariable Long id) {
        return aService.deleteType(id);
    }
}
