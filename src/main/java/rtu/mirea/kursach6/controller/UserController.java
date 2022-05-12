package rtu.mirea.kursach6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rtu.mirea.kursach6.model.Message;
import rtu.mirea.kursach6.model.User;
import rtu.mirea.kursach6.repository.UserRepository;
import rtu.mirea.kursach6.service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;


    @PostMapping(value = "/newuser")
    public ResponseEntity<?> newUser(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> read() {
        final List<User> users = userService.readAll();

        return users != null &&  !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/users/check")
    public ResponseEntity<List<User>> check(@RequestParam String name, String password) {
        return new ResponseEntity<List<User>>(userRepository.findByNameAndPassword(name, password), HttpStatus.OK);
    }
}
