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

    @PostMapping(path = "/register",  consumes = MediaType.APPLICATION_JSON_VALUE)
    User createUser(@RequestBody User userM){
        User user = userRepo.findByName(userM.getName());
        if(user != null){
            return null;
        }
        System.out.println(userM);
        return userRepo.save(userM);
    }

    @PostMapping(path = "/login")
    ResponseEntity loginUser(@RequestBody User userM){
        User user = userRepo.findByNameAndPassword(userM.getName(), userM.getPassword());
        if(user == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
