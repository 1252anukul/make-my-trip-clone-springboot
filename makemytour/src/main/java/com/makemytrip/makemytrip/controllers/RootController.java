package com.makemytrip.makemytrip.controllers;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RootController {
    @GetMapping("/")
    public String home(){return "Its rinning on port 8080";}
}
