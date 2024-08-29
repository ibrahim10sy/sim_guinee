package sim.guinee.controller;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.EnqueteGrossiste;
import sim.guinee.service.EnqueteGrossisteService;

@RestController
@RequestMapping("api-sim/enquete/grossiste")
public class EnqueteGrossisteController {
    
    @Autowired
    EnqueteGrossisteService aService;

    @PostMapping("/addEnqueteGrossiste")
    @Operation(summary="Création de Enquete Grossiste")
    public ResponseEntity<EnqueteGrossiste> create(@RequestBody EnqueteGrossiste a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<EnqueteGrossiste> updateEnqueteGrossiste(@PathVariable int id, @RequestBody EnqueteGrossiste a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getAllEnqueteGrossiste")
    @Operation(summary="Récuperation de tout les Enquetes Collectes")
    public ResponseEntity<List<EnqueteGrossiste>> getAllEnqueteGrossiste() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'une enquete grossiste  à travers id")
    public ResponseEntity<EnqueteGrossiste> getById(@PathVariable int id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé une Enquete grossiste  en  fonction de l'id ")
    public String deleteEnqueteGrossiste(@PathVariable int id) {
        return aService.deleteEnqueteGrossiste(id);
    }
}
