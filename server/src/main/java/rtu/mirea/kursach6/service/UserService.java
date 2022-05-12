package rtu.mirea.kursach6.service;

import rtu.mirea.kursach6.model.Message;
import rtu.mirea.kursach6.model.User;

import java.util.List;

public interface UserService {
    void create(User user);

    List<User> readAll();
}