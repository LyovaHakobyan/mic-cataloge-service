package com.example.miccatalogeservice.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingMessageEndpoint {

    @GetMapping("/")
    public String getGreetingMessage() {
        return "Hello from Application";
    }
}
