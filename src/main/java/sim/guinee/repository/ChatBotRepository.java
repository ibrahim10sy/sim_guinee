package sim.guinee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sim.guinee.model.ChatBot;

@Repository
public interface ChatBotRepository  extends JpaRepository<ChatBot,Long >{
}