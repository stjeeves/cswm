package com.example.codeclan.cswm.controllers;

import com.example.codeclan.cswm.models.User;
import com.example.codeclan.cswm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    //INDEX

    @GetMapping(value="/users")
    public ResponseEntity <List<User>> getAllUsers (){
        List<User> foundUsers = userRepository.findAll();
        return new ResponseEntity<>(foundUsers, HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value="/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    //CREATE
    @PostMapping(value="/users")
    public ResponseEntity<User> postUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //UPDATE
    @PutMapping(value="/users/{id}")
    public ResponseEntity<User> putUser(@RequestBody User user, @PathVariable Long id) {
        if (user.getId().longValue() != id) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(value="/users/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}
