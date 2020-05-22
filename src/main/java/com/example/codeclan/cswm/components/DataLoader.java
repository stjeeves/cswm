package com.example.codeclan.cswm.components;

import com.example.codeclan.cswm.models.Host;
import com.example.codeclan.cswm.models.User;
import com.example.codeclan.cswm.repositories.HostRepository;
import com.example.codeclan.cswm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    HostRepository hostRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Host host1 = new Host("Andrew", "Peattie", 32, "I put the D in drinks", "pubs", "jazz","low", 5);
        hostRepository.save(host1);

        Host host2 = new Host("Jamie", "Bell", 23, "I will ruin your life, or your money back", "pubs", "rock","low", 4);
        hostRepository.save(host2);

        Host host3 = new Host("Stephen", "Watson", 30, "Put a wee umbrella in that mate", "bars", "dance","medium", 5);
        hostRepository.save(host3);

        User user1 = new User ("blah@blah.co.uk", "password1", "John", "Johnson");
        userRepository.save(user1);

        User user2 = new User ("hoohoo@woohoo.com", "robotsareevil", "Tammy", "Tamworth");
        userRepository.save(user2);

    }
}
