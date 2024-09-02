package sim.guinee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import sim.guinee.model.ChatBot;
import sim.guinee.repository.ChatBotRepository;

@Service
public class ChatBotService {
    
     @Autowired
   ChatBotRepository fRepository;

    public ChatBot create(ChatBot f){
        f.setDateEnregistrement(LocalDateTime.now());
        return fRepository.save(f);
    }
}
