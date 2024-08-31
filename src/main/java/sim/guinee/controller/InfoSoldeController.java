package sim.guinee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.InfoSolde;
import sim.guinee.service.InfoSoldeService;

import java.util.*;

@RestController
@RequestMapping("api-sim/infoSolde")
public class InfoSoldeController {
    
     @Autowired
    InfoSoldeService aService;

    @PostMapping("/addInfoSolde")
    @Operation(summary="Création de compte InfoSolde")
    public ResponseEntity<InfoSolde> create(@RequestBody InfoSolde a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<InfoSolde> updateInfoSolde(@PathVariable Long id, @RequestBody InfoSolde a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un InfoSolde à travers id")
    public ResponseEntity<InfoSolde> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getInfoById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllInfoSolde")
    @Operation(summary="Récuperation de tout les InfoSoldes")
    public ResponseEntity<List<InfoSolde>> getAllInfoSolde() {
        return new ResponseEntity<>(aService.getInfoSoldeList(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un InfoSolde en  fonction de l'id ")
    public String deleteInfoSolde(@PathVariable Long id) {
        return aService.deleteInfo(id);
    }

}
