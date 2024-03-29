package com.razz.diusingannotation.dao;

import com.razz.diusingannotation.domain.Book;
import org.springframework.stereotype.Component;

import java.util.List;


public interface BookDao {

    public List<com.razz.diusingannotation.domain.Book> getAllBooks();
    public Book addBook(Book book);
    public boolean deleteBook(int id);
    public Book updateBook(int id, Book book);
    public Book getBookById(int id);

}
