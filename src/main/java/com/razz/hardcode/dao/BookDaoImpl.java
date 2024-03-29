package com.razz.hardcode.dao;

import com.razz.hardcode.domain.Book;
import com.razz.hardcode.utils.LoadBookDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class BookDaoImpl implements BookDao{

    Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(LoadBookDetails.getBooks().values());
    }

    @Override
    public Book addBook(Book book) {
        Map<Integer, Book> books = LoadBookDetails.getBooks();
        Set<Integer> key = books.keySet();
        int counter = key.size();
        return books.put(++counter, book);
    }

    @Override
    public boolean deleteBook(int id) {
        Map<Integer, Book> books = LoadBookDetails.getBooks();
        Book book = books.get(id);
        return books.remove(id, book);
    }

    @Override
    public Book updateBook(int id, Book book) {
        Map<Integer, Book> books = LoadBookDetails.getBooks();
        books.put(id, book);
        return book;
    }

    @Override
    public Book getBookById(int id) {
        Map<Integer, Book> books = LoadBookDetails.getBooks();
        Book book = null;
        if(!books.isEmpty()) {
            if (books.get(id) != null) {
                book = books.get(id);
            }
        }
        return book;
    }
}
