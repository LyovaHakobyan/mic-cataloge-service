package com.example.miccatalogeservice.config;

import com.example.miccatalogeservice.repository.BookRepository;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataClearConfig {

    private final BookRepository bookRepository;

//    @PreDestroy
//    public void clearDatabase() {
//        bookRepository.deleteAll();
//    }
}
