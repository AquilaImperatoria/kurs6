package rtu.mirea.kursach6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rtu.mirea.kursach6.model.Message;
import rtu.mirea.kursach6.repository.MessageRepository;
import rtu.mirea.kursach6.service.MessageService;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageService messageService;


    @PostMapping(value = "/newchat")
    public ResponseEntity<?> newChat(@RequestParam String usernam) {
        String response = messageService.createChat(usernam);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping(value = "/messages/new")
    public ResponseEntity<?> create(@RequestBody Message message) {
        messageService.create(message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/messages")
    public ResponseEntity<List<Message>> read() {
        final List<Message> messages = messageService.readAll();

        return messages != null &&  !messages.isEmpty()
                ? new ResponseEntity<>(messages, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/messages/getchatcode")
    public ResponseEntity<List<Message>> getMessagesByChatcode(@RequestParam String chatcode) {
        return new ResponseEntity<List<Message>>(messageRepository.getByChatcode(chatcode), HttpStatus.OK);
    }
    @GetMapping("/messages/getuser")
    public ResponseEntity<List<Message>> getMessagesByUsernam(@RequestParam String user) {
        return new ResponseEntity<List<Message>>(messageRepository.getByUsernam(user), HttpStatus.OK);
    }
    @GetMapping("/messages/delchatCODE")
    public ResponseEntity<List<Message>> deleteMessagesByChatCODE(@RequestParam String chatcode) {
        return new ResponseEntity<List<Message>>(messageRepository.deleteByChatcode(chatcode), HttpStatus.OK);
    }
}
