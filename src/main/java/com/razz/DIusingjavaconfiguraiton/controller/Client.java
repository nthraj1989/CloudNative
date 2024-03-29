package com.razz.DIusingjavaconfiguraiton.controller;

import com.razz.DIusingjavaconfiguraiton.config.AppConfig;
import com.razz.DIusingjavaconfiguraiton.dto.BookDTO;
import com.razz.DIusingjavaconfiguraiton.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Client {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(Client.class);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BookService bookService = ctx.getBean("bookService", BookService.class);

        /*
        *
        // Get book by ID...
//          BookDTO book = bookService.getBookById(1);
//          log.info("{}",book);


        // Get all Books

//        List<BookDTO> allBooks = bookService.getAllBooks();
//        log.info("{}\n",allBooks);

        /*
        * Add book
        * /

       // String message = bookService.addBook(new BookDTO("ISBN8888", "MicroServices", "action", 5000));
       // log.info("{}",message);

//        BookDTO addBook1 = bookService.addBook(new BookDTO("ISBN9999", "MicroServicesWithNode", "action", 3000));
//        log.info("{}",addBook1);


//        BookDTO addBook2 = bookService.addBook(new BookDTO( "ISBN1010", "MicroServicesWithPython", "action", 2400));
//        log.info("{}",addBook2);

        /*
        * update book
        * /
       // String message  = bookService.updateBook (3,new BookDTO("ISBN6512", "Spring", "Rod jon", 0));
        //log.info("{}",message);

        bookService.deleteBook(9);
}
}
        * */

        bookService.deleteBook(2);

    }
}