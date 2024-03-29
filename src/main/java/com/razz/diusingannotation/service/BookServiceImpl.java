package com.razz.diusingannotation.service;


import com.razz.diusingannotation.dao.BookDao;
import com.razz.diusingannotation.domain.Book;
import com.razz.diusingannotation.exception.BookNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value="bookService")
public class BookServiceImpl implements BookService {
   @Autowired
   private BookDao bookDao;


    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        Book dBook;
       if(book != null){
           dBook = bookDao.addBook(book);
       }else{
           throw new BookNotFound("Book cannot be empty");
       }
       return dBook;
    }

    @Override
    public boolean deleteBook(int id) {
        boolean delted = false;
       if(id>0){
           delted = bookDao.deleteBook(id);
       }
        return delted;
    }

    @Override
    public Book updateBook(int id, Book book) {
        Book updated = null;
        if( book != null && id >0) {
             updated = bookDao.updateBook(id, book);
        }else{
            throw new BookNotFound("No books available in store");
        }
         return updated;
    }

    @Override
    public Book getBookById(int id) {
        Book book = null;
        if(id>0){
             book = bookDao.getBookById(id);
        }
        return book;
    }
}
