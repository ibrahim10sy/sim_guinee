package sim.guinee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.AutreMsg;
import sim.guinee.service.AutreMsgService;


@RestController
@RequestMapping("api-sim/autreMsg")
public class AutreMsgController {
    
     @Autowired
    AutreMsgService aService;

    @PostMapping("/addMsg")
    @Operation(summary="Add autreMsg personnel ")
    public ResponseEntity<AutreMsg> createMsg(@RequestBody AutreMsg a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<AutreMsg> updateMsg(@PathVariable Long id, @RequestBody AutreMsg a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un msg")
    public ResponseEntity<AutreMsg> getById(@PathVariable Long id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllMsg")
    @Operation(summary="Récuperation de tout les Msg")
    public ResponseEntity<List<AutreMsg>> getAllAutreMsgnnele() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Msg en  fonction de l'id ")
    public String deleteMsg(@PathVariable Long id) {
        return aService.deleteAutreMsg(id);
    }
}
