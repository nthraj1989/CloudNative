package com.razz.diusingannotation.utils;

import com.razz.diusingannotation.domain.Book;

import java.util.HashMap;
import java.util.Map;

public class LoadBookDetails {
    private static Map<Integer, Book> bookDetails = new HashMap<>();
/*
*  private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;*/
    public static Map<Integer,Book> getBooks(){

        bookDetails.put(1,new Book(1,"ISBN2651","Java","oracle",2000));
        bookDetails.put(2,new Book(2,"ISBN1563","JS","JSworld",500));
        bookDetails.put(3,new Book(3,"ISBN6512","Spring","Rod",1234));
        bookDetails.put(4,new Book(4,"ISBN3333","Hibernate","Galvin",1254));
        bookDetails.put(5,new Book(5,"ISBN4444","SQL","SQL world",7851));
        bookDetails.put(6,new Book(6,"ISBN5555","Design Pattern","Head First",2212));

        return bookDetails;
    }
}
