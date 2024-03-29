package com.razz.diusingannotation.controller;

import com.razz.diusingannotation.domain.Book;
import com.razz.diusingannotation.service.BookService;
import com.razz.diusingannotation.service.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(Client.class);

        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("beans.xml");
        BookService bookService = ctx.getBean("bookService", BookServiceImpl.class);


//        Book book = bookService.getBookById(1);
//        log.info("Book with {},{} ",book.getId(),book);

//        List<Book> allBooks = bookService.getAllBooks();
//        log.info("List of all books {}",allBooks);
        Book addBook = bookService.addBook(new Book(7, "ISBN8888", "MicroServices", "action", 5000));
        Book addBook1 = bookService.addBook(new Book(8, "ISBN9999", "MicroServicesWithNode", "action", 3000));
        Book addBook2 = bookService.addBook(new Book(9, "ISBN1010", "MicroServicesWithPython", "action", 2400));
        log.info("Book with {},{} is added ",addBook.getId(),addBook);
        log.info("Book with {},{} is added ",addBook1.getId(),addBook1);
        log.info("Book with {},{} is added ",addBook2.getId(),addBook2);
        Book updatedBook = bookService.updateBook(3, new Book(3, "ISBN6512", "Spring", "Rod jon", 0));
        log.info("Book with {},{} is successfully updated ",updatedBook.getId(),updatedBook);


    }
}
