package com.example.codeclan.cswm.controllers;

import com.example.codeclan.cswm.models.Host;
import com.example.codeclan.cswm.repositories.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HostController {

    @Autowired
    HostRepository hostRepository;

    @GetMapping(value= "/host")
    public ResponseEntity<List<Host>> getHosts(){
        List<Host> foundHosts = hostRepository.findAll();
        return new ResponseEntity<>(foundHosts, HttpStatus.OK);
    }
}
