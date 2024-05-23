package com.example.miccatalogeservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank(message = "Isbn cannot be empty.")
    String isbn;

    @NotBlank(message = "Title cannot be empty.")
    String title;

    @NotBlank(message = "Author cannot be empty.")
    String author;

    @Min(0)
    @Max(9999999)
    Double price;

    @Version
    int version;

    public static Book of(String isbn, String title, String author, Double price) {
        return new Book(null, isbn, title, author, price, 0);
    }

}
