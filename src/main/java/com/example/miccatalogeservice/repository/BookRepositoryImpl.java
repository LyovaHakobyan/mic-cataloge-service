package com.example.miccatalogeservice.repository;

import com.example.miccatalogeservice.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final Map<String, Book> bookMap = new HashMap<>();

    @Override
    public List<Book> findAllBooks() {
        return bookMap.values().stream().toList();
    }

    @Override
    public Optional<Book> findBookByIsbn(String isbn) {
        try {
            return Optional.of(bookMap.get(isbn));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Book addBook(Book book) {
        return bookMap.put(book.isbn(), book);
    }

    @Override
    public void deleteBookByIsbn(String isbn) {
        bookMap.remove(isbn);
    }

}
