package com.example.codeclan.cswm.controllers;

import com.example.codeclan.cswm.models.Host;
import com.example.codeclan.cswm.models.User;
import com.example.codeclan.cswm.repositories.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HostController {

    @Autowired
    HostRepository hostRepository;


    //INDEX
    @GetMapping(value= "/hosts")
    public ResponseEntity<List<Host>> getAllHosts(){
        List<Host> foundHosts = hostRepository.findAll();
        return new ResponseEntity<>(foundHosts, HttpStatus.OK);
    }

    //SHOW
    @GetMapping(value="/hosts/{id}")
    public ResponseEntity getHost(@PathVariable Long id){
        return new ResponseEntity<>(hostRepository.findById(id), HttpStatus.OK);
    }

    //CREATE
    @PostMapping(value="/hosts")
    public ResponseEntity<User> postHost(@RequestBody Host host){
        hostRepository.save(host);
        return new ResponseEntity(host, HttpStatus.CREATED);
    }

    //UPDATE
    @PutMapping(value="/hosts/{id}")
    public ResponseEntity<Host> putHost(@RequestBody Host host, @PathVariable Long id) {
        if (host.getId().longValue() != id) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        hostRepository.save(host);
        return new ResponseEntity<>(host, HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(value="/hosts/{id}")
    public ResponseEntity<List<Host>> deleteHost(@PathVariable Long id){
        hostRepository.deleteById(id);
        return new ResponseEntity<>(hostRepository.findAll(), HttpStatus.OK);
    }

}
