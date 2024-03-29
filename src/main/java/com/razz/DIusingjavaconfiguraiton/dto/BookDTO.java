package com.razz.DIusingjavaconfiguraiton.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BookDTO {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;

    public BookDTO(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
