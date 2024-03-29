package com.razz.diwithxml.dao;

import com.razz.hardcode.domain.Book;

import java.util.List;

public interface BookDao {

    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public boolean deleteBook(int id);
    public Book updateBook(int id, Book book);
    public Book getBookById(int id);

}
