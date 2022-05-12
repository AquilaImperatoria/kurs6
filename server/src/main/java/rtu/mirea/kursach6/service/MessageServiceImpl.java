package rtu.mirea.kursach6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtu.mirea.kursach6.model.Message;
import rtu.mirea.kursach6.repository.MessageRepository;

import java.util.*;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void create(Message message) {

        messageRepository.save(message);
    }
    @Override
    public String createChat(String name) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        String num = sb.toString();
        Message message = new Message();
        message.setChatcode(num);
        message.setUsernam(name);
        message.setContent(name+", your chat code is "+num+"!");
        messageRepository.save(message);
        return num;
    }

    @Override
    public List<Message> readAll() {
        return messageRepository.findAll();
    }

}
