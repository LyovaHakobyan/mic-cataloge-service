package com.example.miccatalogeservice.endpoint;

import com.example.miccatalogeservice.config.BookshopProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingMessageEndpoint {

    private final BookshopProperties bookshopProperties;

    @GetMapping("/")
    public String getGreetingMessage() {
        return bookshopProperties.getGreeting();
    }
}
