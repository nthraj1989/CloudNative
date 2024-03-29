package com.razz.hardcode.controller;

import com.razz.hardcode.domain.Book;
import com.razz.hardcode.service.BookService;
import com.razz.hardcode.service.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(Client.class);

        BookService service = new BookServiceImpl();

        Book book = service.getBookById(1);
        log.info("Book with {},{} ",book.getId(),book);

        List<Book> allBooks = service.getAllBooks();
        log.info("List of all books {}",allBooks);
        // doa.addBook(new Book(7,"ISBN8888","MicroServices","action",5000));
       // doa.updateBook(3,new Book(3,"ISBN6512","Spring","Rod jon",0));



    }
}
