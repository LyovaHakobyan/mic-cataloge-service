package com.example.miccatalogeservice.repository;

import com.example.miccatalogeservice.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAllBooks();

    Optional<Book> findBookByIsbn(String isbn);

    Book addBook(Book book);

    void deleteBookByIsbn(String isbn);
}
