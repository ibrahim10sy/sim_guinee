package sim.guinee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import sim.guinee.model.ChatBot;
import sim.guinee.service.ChatBotService;

@RestController
@RequestMapping("api-sim/chat")
public class ChatBotControler {
    
    @Autowired
    ChatBotService aService;

    @PostMapping("/addChatBot")
    @Operation(summary="Création de compte ChatBot")
    public ResponseEntity<ChatBot> create(@RequestBody ChatBot a ) {
        return new ResponseEntity<>(aService.create(a), HttpStatus.OK);
    }

}
