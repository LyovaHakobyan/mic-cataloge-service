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
        return bookRepository.findAllBooks();
    }

    public Book findByIsbn(String isbn) throws BookNotFoundException {
        return bookRepository.findBookByIsbn(isbn).orElseThrow(BookNotFoundException::new);
    }

    public Book addBook(Book book) throws BookAlreadyExistsException {
        if (bookRepository.findBookByIsbn(book.isbn()).isPresent()) {
            throw new BookAlreadyExistsException();
        }
        return bookRepository.addBook(book);
    }

    public void deleteBookByIsbn(String isbn) throws BookNotFoundException {
        if (bookRepository.findBookByIsbn(isbn).isEmpty()) {
            throw new BookNotFoundException();
        }
        bookRepository.deleteBookByIsbn(isbn);
    }
}
