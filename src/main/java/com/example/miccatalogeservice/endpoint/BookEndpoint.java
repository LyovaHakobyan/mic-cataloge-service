package com.example.miccatalogeservice.endpoint;

import com.example.miccatalogeservice.entity.Book;
import com.example.miccatalogeservice.exception.BookAlreadyExistsException;
import com.example.miccatalogeservice.exception.BookNotFoundException;
import com.example.miccatalogeservice.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookEndpoint {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) throws BookNotFoundException {
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book) throws BookAlreadyExistsException {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @DeleteMapping("/delete/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByIsbn(@PathVariable String isbn) throws BookNotFoundException {
        bookService.deleteBookByIsbn(isbn);
    }
}
