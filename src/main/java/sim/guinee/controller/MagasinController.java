package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Magasin;
import sim.guinee.service.MagasinService;

@RestController
@RequestMapping("api-sim/magasin")
public class MagasinController {
 
    @Autowired
    MagasinService aService;

    @PostMapping("/addMagasin")
    @Operation(summary="Création de Magasin")
    public ResponseEntity<Magasin> create(@RequestBody Magasin a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Magasin> updateMagasin(@PathVariable Long id, @RequestBody Magasin a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un Magasin à travers id")
    public ResponseEntity<Magasin> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllMagasin")
    @Operation(summary="Récuperation de tout les Magasins")
    public ResponseEntity<List<Magasin>> getAllMagasin() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllByMarche/{nomMarche}")
    @Operation(summary="Récuperation de tout les Magasins")
    public ResponseEntity<List<Magasin>> getAllMagasinByMarche(@PathVariable String nomMarche) {
        return new ResponseEntity<>(aService.getAllByMarche(nomMarche), HttpStatus.OK);
    }

    @GetMapping("/getAllByLocalite/{localite}")
    @Operation(summary="Récuperation de tout les Magasins")
    public ResponseEntity<List<Magasin>> getAllMagasinByLocalite(@PathVariable String localiteMagasin) {
        return new ResponseEntity<>(aService.getAllByLocalite(localiteMagasin), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Magasin en  fonction de l'id ")
    public String deleteMagasin(@PathVariable Long id) {
        return aService.deleteMagasin(id);
    }
}
