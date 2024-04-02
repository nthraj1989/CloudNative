package com.razz.DIusingjavaconfiguraiton.service;

import com.razz.DIusingjavaconfiguraiton.dto.BookDTO;

import java.util.List;

public interface BookService {

    public List<BookDTO> getAllBooks();
    public String addBook(BookDTO book);
    public int deleteBook(int id);
    public String updateBook(int id, BookDTO book);
    public BookDTO getBookById(int id);

}
