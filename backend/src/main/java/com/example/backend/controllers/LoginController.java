package com.example.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.db.UserRepo;
import com.example.backend.models.UserLogin;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    // @GetMapping("/dohvati/{username}/{idAkt}")
    // public boolean postojiPrijava(@PathVariable String username, @PathVariable
    // int idAkt) {
    // return new PrijaveRepo().postojiPrijava(username, idAkt);
    // }

    @PostMapping("/login")
    public UserLogin login(@RequestBody UserLogin user) {
        return new UserRepo().login(user);
    }

}
