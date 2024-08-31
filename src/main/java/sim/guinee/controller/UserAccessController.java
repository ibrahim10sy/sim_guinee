
package sim.guinee.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.UserAccess;
import sim.guinee.service.UserAccessService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("api-sim/userAccess")
public class UserAccessController {
    
    @Autowired
    UserAccessService aService;

    @PostMapping("/addUserAccess")
    @Operation(summary="Création de User Access ")
    public ResponseEntity<UserAccess> create(@RequestBody UserAccess a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<UserAccess> updateUserAccess(@PathVariable Long id, @RequestBody UserAccess a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }

    @GetMapping("/getAllByPersonnel/{id}")
    @Operation(summary="Récuperation de tout les UserAccesss ")
    public ResponseEntity<List<UserAccess>> getAllUserAccessByPersonnel(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getAllByPersonnel(id), HttpStatus.OK);
    }
   
    @GetMapping("/getAllUserAccess")
    @Operation(summary="Récuperation de tout les access")
    public ResponseEntity<List<UserAccess>> getAllUserAccess() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un access  en  fonction de l'id ")
    public String deleteUserAccess(@PathVariable Long id) {
        return aService.deleteAccess(id);
    }

}
