package sim.guinee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.EnvoiMsg;
import sim.guinee.service.EnvoiMsgService;


@RestController
@RequestMapping("api-sim/envoiMsg")
public class EnvoiMsgController {
    
    @Autowired
    EnvoiMsgService aService;

    @PostMapping("/addMsg")
    @Operation(summary="Add EnvoiMsg ")
    public ResponseEntity<EnvoiMsg> createMsg(@RequestBody EnvoiMsg a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification  à travers id")
    public ResponseEntity<EnvoiMsg> updateMsg(@PathVariable int id, @RequestBody EnvoiMsg a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
 
    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un msg")
    public ResponseEntity<EnvoiMsg> getById(@PathVariable int id) {
        return new ResponseEntity<>(aService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllMsg")
    @Operation(summary="Récuperation de tout les Msg")
    public ResponseEntity<List<EnvoiMsg>> getAllEnvoiMsgnnele() {
        return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un Msg en  fonction de l'id ")
    public String deleteMsg(@PathVariable int id) {
        return aService.delete(id);
    }
}
