package com.example.miccatalogeservice.demo;

import com.example.miccatalogeservice.entity.Book;
import com.example.miccatalogeservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Profile("testdata")
@RequiredArgsConstructor
@Component
public class BookDataLoader {

    private final BookRepository bookRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void addData() {
        var book1 = new Book("123456", "Title1", "Author1", 123.123);
        var book2 = new Book("456789", "Title2", "Author2", 456.456);
        var book3 = new Book("789123", "Title3", "Author3", 789.789);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);
        bookRepository.addBook(book3);
    }
}
