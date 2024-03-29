package com.razz.diusingannotation.dao;

import com.razz.diusingannotation.domain.Book;
import com.razz.diusingannotation.utils.LoadBookDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component(value="bookDao")
public class BookDaoImpl implements BookDao {

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
        books.put(++counter, book);
        return books.get(counter);
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
        return books.get(id);
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
