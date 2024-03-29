package com.razz.hardcode.service;

import com.razz.hardcode.domain.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public boolean deleteBook(int id);
    public Book updateBook(int id, Book book);
    public Book getBookById(int id);

}
