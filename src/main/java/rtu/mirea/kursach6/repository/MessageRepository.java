package rtu.mirea.kursach6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rtu.mirea.kursach6.model.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> getByChatcode(String chatcode);
    List<Message> deleteByChatcode(String chatcode);
    List<Message> getByUsernam(String user);
}
