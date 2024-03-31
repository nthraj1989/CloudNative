package com.razz.DIusingjavaconfiguraiton.dao;

import com.razz.DIusingjavaconfiguraiton.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component(value = "bookDao")
@Primary
//@Profile(value="dev")
public class BookDaoJDBCTemplateImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDaoJDBCTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        String query ="select * from book";
        return jdbcTemplate.query(query, new AccountRowMapper());
    }

    @Override
    public String addBook(BookDTO book) {
        String sql="insert into book(isbn,title,author,price) values(?,?,?,?)";
        int update = jdbcTemplate.update(sql, new Object[]{book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice()});
        return String.valueOf(update);
    }

    @Override
    public String updateBook(int id, BookDTO book) {
        String sql="update book set isbn=?,title=?, author=? ,price=? where id=?";
        int update = jdbcTemplate.update(sql, new Object[]{book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice(), id});
        return String.valueOf(update);
    }

    @Override
    public int deleteBook(int id) {
        String sql = "delete from book where id=?";
        return  jdbcTemplate.update(sql, new Object[]{id});
    }



    @Override
    public BookDTO getBookById(int id) {
        String query = "select * from book where id=?";
        return jdbcTemplate.queryForObject(query, new AccountRowMapper(), id);
    }
}
