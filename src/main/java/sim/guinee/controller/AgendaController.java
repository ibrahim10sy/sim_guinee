package sim.guinee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.AgendaPerso;
import sim.guinee.service.AgendaPersoService;


@RestController
@RequestMapping("api-sim/agenda")
public class AgendaController {
    
    @Autowired
    AgendaPersoService aService;

    @PostMapping("/addAgenda")
    @Operation(summary="Création d'agenda personnel ")
    public ResponseEntity<AgendaPerso> createAgenda(@RequestBody AgendaPerso a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @Operation(summary="Modification d'un agenda à travers id")
    public ResponseEntity<AgendaPerso> updateAgenda(@PathVariable int id, @RequestBody AgendaPerso a ){
        return new ResponseEntity<>(aService.update(a, id), HttpStatus.OK);
    }
  
    @GetMapping("/getByPersonnel/{string}")
    @Operation(summary="Récuperation des agenda d'un personnel ")
    public ResponseEntity<List<AgendaPerso>> getAllAgendaById(@PathVariable String id) {
        return new ResponseEntity<>(aService.getAllAgendaByPersonnel(id), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    @Operation(summary="Récuperation d'un agenda")
    public ResponseEntity<AgendaPerso> getAgendaById(@PathVariable int id) {
        return new ResponseEntity<>(aService.getAgendaPersoById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllAgenda")
    @Operation(summary="Récuperation de tout les agenda")
    public ResponseEntity<List<AgendaPerso>> getAllAgendaPersonnele() {
        return new ResponseEntity<>(aService.getAllAgendaPerso(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary="Supprimé d'un agenda en  fonction de l'id ")
    public String delete(@PathVariable int id) {
        return aService.deleteAgenda(id);
    }
}
