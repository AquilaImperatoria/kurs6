package rtu.mirea.kursach6.service;

import rtu.mirea.kursach6.model.Message;

import java.util.List;

public interface MessageService {
    void create(Message message);
    List<Message> readAll();
    String createChat(String name);

}
