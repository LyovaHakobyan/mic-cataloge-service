package com.example.miccatalogeservice.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record Book(
        @NotBlank(message = "Isbn cannot be empty.")
        String isbn,

        @NotBlank(message = "Title cannot be empty.")
        String title,

        @NotBlank(message = "Author cannot be empty.")
        String author,

        @Min(0)
        @Max(9999999)
        double price
) {
}
