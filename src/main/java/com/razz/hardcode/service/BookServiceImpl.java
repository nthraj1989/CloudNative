package com.razz.hardcode.service;

import com.razz.hardcode.dao.BookDao;
import com.razz.hardcode.dao.BookDaoImpl;
import com.razz.hardcode.domain.Book;
import com.razz.hardcode.exception.BookNotFound;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();


    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        Book dBook=null;
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
