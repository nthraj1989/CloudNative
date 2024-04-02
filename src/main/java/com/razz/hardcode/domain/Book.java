package com.razz.hardcode.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;


}
