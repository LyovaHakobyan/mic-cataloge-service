package com.example.miccatalogeservice.service;

import com.example.miccatalogeservice.entity.Book;
import com.example.miccatalogeservice.exception.BookAlreadyExistsException;
import com.example.miccatalogeservice.exception.BookNotFoundException;
import com.example.miccatalogeservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findByIsbn(String isbn) throws BookNotFoundException {
        return bookRepository.findByIsbn(isbn).orElseThrow(BookNotFoundException::new);
    }

    public Book addBook(Book book) throws BookAlreadyExistsException {
        if (bookRepository.findByIsbn(book.getIsbn()).isPresent()) {
            throw new BookAlreadyExistsException();
        }
        return bookRepository.save(book);
    }

    public void deleteBookByIsbn(String isbn) throws BookNotFoundException {
        if (bookRepository.findByIsbn(isbn).isEmpty()) {
            throw new BookNotFoundException();
        }
        bookRepository.deleteByIsbn(isbn);
    }
}
