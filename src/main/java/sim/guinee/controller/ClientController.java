package sim.guinee.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.Client;
import sim.guinee.service.ClientService;

@RestController
@RequestMapping("api-sim/client")
public class ClientController {
    
    @Autowired
    ClientService aService;

    @PostMapping("/addClient")
    @Operation(summary="Création de compte client")
    public ResponseEntity<Client> create(@RequestBody Client a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un client à travers id")
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllClient")
    @Operation(summary="Récuperation de tout les clents")
    public ResponseEntity<List<Client>> getAllClient() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un client en  fonction de l'id ")
    public String deleteClient(@PathVariable Long id) {
        return aService.deleteClient(id);
    }


}
