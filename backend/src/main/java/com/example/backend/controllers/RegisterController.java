package com.example.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend.db.UserRepo;
import com.example.backend.models.ResponseMessage;
import com.example.backend.models.User;
import com.example.backend.models.UserLogin;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {
    private UserRepo userRepo = new UserRepo();

    // @GetMapping("/dohvati/{username}/{idAkt}")
    // public boolean postojiPrijava(@PathVariable String username, @PathVariable
    // int idAkt) {
    // return new PrijaveRepo().postojiPrijava(username, idAkt);
    // }

    @PostMapping("/register")
    public Boolean register(@RequestBody User user) {
        System.out.println("register!");
        return userRepo.register(user);
    }

    @PostMapping("/hello")
    public void postMethodName() {
        System.out.println("hello");
        // TODO: process POST request

        return;
    }

    // @RequestParam("username") String username,
    @PostMapping("/uploadImage")
    public ResponseEntity<ResponseMessage> handleFileUpload(
            @RequestParam("profilePicture") MultipartFile file) {
        String message = "";
        System.out.println("print1");
        try {
            System.out.println("print2");
            userRepo.handleFileUpload(file); // username,
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
}