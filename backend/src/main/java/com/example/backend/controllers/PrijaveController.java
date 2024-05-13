package com.example.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.db.PrijaveRepo;

@RestController
@RequestMapping("/prijave")
@CrossOrigin(origins = "http://localhost:4200")
public class PrijaveController {

    @GetMapping("/dohvati/{username}/{idAkt}")
    public boolean postojiPrijava(@PathVariable String username, @PathVariable int idAkt) {
        return new PrijaveRepo().postojiPrijava(username, idAkt);
    }

    @PostMapping("/prijaviAktivnost/{username}/{idAkt}/{brSale}")
    public boolean prijava(@PathVariable String username, @PathVariable int idAkt, @PathVariable int brSale) {
        return new PrijaveRepo().prijaviAktivnost(username, idAkt, brSale);
    }
}
