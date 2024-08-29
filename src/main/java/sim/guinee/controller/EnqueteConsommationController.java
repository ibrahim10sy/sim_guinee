package sim.guinee.controller;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.EnqueteConsommation;
import sim.guinee.service.EnqueteConsommationService;

@RestController
@RequestMapping("api-sim/enquete/consommation")
public class EnqueteConsommationController {
    
    @Autowired
    EnqueteConsommationService aService;

    @PostMapping("/addEnqueteConsommation")
    @Operation(summary="Création de Enquete Consommation")
    public ResponseEntity<EnqueteConsommation> create(@RequestBody EnqueteConsommation a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<EnqueteConsommation> updateEnqueteConsommation(@PathVariable int id, @RequestBody EnqueteConsommation a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getAllEnqueteConsommation")
    @Operation(summary="Récuperation de tout les Enquetes consommation")
    public ResponseEntity<List<EnqueteConsommation>> getAllEnqueteConsommation() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'une enquete consommation  à travers id")
    public ResponseEntity<EnqueteConsommation> getById(@PathVariable int id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé une Enquete consommation  en  fonction de l'id ")
    public String deleteEnqueteConsommation(@PathVariable int id) {
        return aService.deleteEnqueteConsommation(id);
    }

}
