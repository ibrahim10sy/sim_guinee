package sim.guinee.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import sim.guinee.config.ResponseHandler;
import sim.guinee.model.Personnel;
import sim.guinee.service.PersonnelService;

@RestController
@RequestMapping("api-sim/personnel")
public class PersonnelController {
    
    @Autowired
    PersonnelService aService;

    @PostMapping("/create")
    @Operation(summary = "création d'un personnel")
    public ResponseEntity<Personnel> create(
            @Valid @RequestParam("personnel") String acteurString,
            @RequestParam(value = "avatar", required = false) MultipartFile imageFile
           )
            throws Exception {
                

                Personnel per = new Personnel();
                try {
                    per = new JsonMapper().readValue(acteurString, Personnel.class);
                } catch (JsonProcessingException e) {
                    throw new Exception(e.getMessage());
                }
            
                Personnel saved = aService.create(per, imageFile);
                System.out.println(" controller :" + saved);

                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            }
   
            @PutMapping("/update/{id}")
    @Operation(summary = "Modification d'un personnel")
    public ResponseEntity<Personnel> update(
            @Valid @RequestParam("personnel") String acteurString,
            @PathVariable Long idPersonnel,
            @RequestParam(value = "avatar", required = false) MultipartFile imageFile
           )
            throws Exception {
                

                Personnel per = new Personnel();
                try {
                    per = new JsonMapper().readValue(acteurString, Personnel.class);
                } catch (JsonProcessingException e) {
                    throw new Exception(e.getMessage());
                }
            
                Personnel saved = aService.update(per, idPersonnel,imageFile);
                System.out.println(" controller :" + saved);

                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            }

            @PutMapping("/{id}/password")
            public Personnel updatePass(@PathVariable Long id, @RequestParam String password) throws Exception {
                return aService.updatePassWord(id, password);
            }
            
            @GetMapping("/sendOtpCodeWhatsApp")
            @Operation(summary = "Verifier le numéro de l'utilisateur en lui envoyant un code de verification à numéro whatsApp pour la procedure de changement de son mot de pass")
            @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Le numéro exist et le code a été envoyer avec succès", content = {
                    @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "500",description = "Erreur serveur", content = @Content),
            })
            public ResponseEntity<Object> sendOtpCodeWhatsApp(@RequestParam("whatsAppActeur") String whatsAppActeur) throws Exception {
                return ResponseHandler.generateResponse(aService.sendOtpCodeWhatsApp(whatsAppActeur), HttpStatus.OK,null);
            }

            @PutMapping("/activer/{id}")
            @Operation(summary="Activation du compte ")
            public ResponseEntity<Personnel> activerPersonnel(@PathVariable Long id ){
                return new ResponseEntity<>(aService.activer(id), HttpStatus.OK);
            }

            @PutMapping("/desactiver/{id}")
            @Operation(summary="Desactivation  du compte ")
            public ResponseEntity<Personnel> desactiverPersonnel(@PathVariable Long id ){
                return new ResponseEntity<>(aService.desactiver(id), HttpStatus.OK);
            }

            @GetMapping("/getAllPersonnel")
            @Operation(summary="Récuperation de tout les clents")
            public ResponseEntity<List<Personnel>> getAllPersonnel() {
                return new ResponseEntity<>(aService.getAll(), HttpStatus.OK);
            }

            @DeleteMapping("/delete/{id}")
            @Operation(summary="Supprimé d'un Personnel en  fonction de l'id ")
            public String deletePersonnel(@PathVariable Long id) {
                return aService.deletePersonnel(id);
            }

}
