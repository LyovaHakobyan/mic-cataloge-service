package com.example.miccatalogeservice.repository;

import com.example.miccatalogeservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByIsbn(String isbn);

    void deleteByIsbn(String isbn);
}
