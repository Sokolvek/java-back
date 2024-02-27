package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UsersRestApi {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    Iterable<User> getAllUsers(){ return userRepo.findAll(); }

    @PostMapping(path = "/signup",  consumes = MediaType.APPLICATION_JSON_VALUE)
    User createUser(@RequestBody User userM){
        User user = userRepo.findByName(userM.getName());
        if(user != null){
            return null;
        }
        System.out.println(userM);
        return userRepo.save(userM);
    }

    @PostMapping(path = "/login",  consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    ResponseEntity<User> loginUser(@RequestBody User userM){
        User user = userRepo.findByNameAndPassword(userM.getName(), userM.getPassword());
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<User>(HttpStatus.OK);
    }
}
