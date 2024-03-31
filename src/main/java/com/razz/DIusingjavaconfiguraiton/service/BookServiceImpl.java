package com.razz.DIusingjavaconfiguraiton.service;

import com.razz.DIusingjavaconfiguraiton.dao.BookDao;
import com.razz.DIusingjavaconfiguraiton.dto.BookDTO;
import com.razz.DIusingjavaconfiguraiton.exception.BookNotFound;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component(value="bookService")
@Setter
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;


    @Override
    public List<BookDTO> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public String addBook(BookDTO book) {
        String message = null;
       if(book != null){
           message = bookDao.addBook(book);
       }else{
           throw new BookNotFound("Book cannot be empty");
       }
       return message;
    }

    @Override
    public int deleteBook(int id) {
        int delted = 0;
       if(id>0){
           delted = bookDao.deleteBook(id);
       }
       if(delted<0){
           throw new BookNotFound("No Book found to delte");
       }
        return delted;
    }

    @Override
    public String updateBook(int id, BookDTO book) {
        String message = null;
        if( book != null && id >0) {
            message = bookDao.updateBook(id, book);
        }else{
            throw new BookNotFound("No books available in store");
        }
         return message;
    }

    @Override
    public BookDTO getBookById(int id) {
        BookDTO book = null;
        if(id>0){
             book = bookDao.getBookById(id);
        }
        return book;
    }
}
