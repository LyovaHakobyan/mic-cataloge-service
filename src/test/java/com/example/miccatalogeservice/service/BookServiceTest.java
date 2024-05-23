package com.example.miccatalogeservice.service;

import com.example.miccatalogeservice.entity.Book;
import com.example.miccatalogeservice.exception.BookNotFoundException;
import com.example.miccatalogeservice.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;

    @BeforeEach
    public void setUp() {
        book = Book.of(
                "1234567890",
                "Test Book",
                "Test Author",
                29.99
        );
    }

    @Test
    public void testFindByIsbn_BookFound() throws BookNotFoundException {
        // Arrange
        when(bookRepository.findByIsbn("1234567890")).thenReturn(Optional.of(book));

        // Act
        Book foundBook = bookService.findByIsbn("1234567890");

        // Assert
        assertNotNull(foundBook);
        assertEquals("1234567890", foundBook.getIsbn());
        assertEquals("Test Book", foundBook.getTitle());
        assertEquals("Test Author", foundBook.getAuthor());
        assertEquals(29.99, foundBook.getPrice());
        verify(bookRepository, times(1)).findByIsbn("1234567890");
    }

    @Test
    public void testFindByIsbn_BookNotFound() {
        // Arrange
        when(bookRepository.findByIsbn("1234567890")).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(BookNotFoundException.class, () -> {
            bookService.findByIsbn("1234567890");
        });
        verify(bookRepository, times(1)).findByIsbn("1234567890");
    }

}