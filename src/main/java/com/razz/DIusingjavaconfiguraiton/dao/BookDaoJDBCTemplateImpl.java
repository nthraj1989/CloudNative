package com.razz.DIusingjavaconfiguraiton.dao;

import com.razz.DIusingjavaconfiguraiton.dto.BookDTO;
import com.razz.DIusingjavaconfiguraiton.utils.JDBCConn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component(value = "bookDao")
public class BookDaoJDBCTemplateImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDaoJDBCTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookDTO = new ArrayList<>();
        String query ="select * from book";
        jdbcTemplate.query(query, (rs, i)-> {
                           return  new BookDTO(rs.getInt("id"),
                                     rs.getString("isbn"),
                                     rs.getString("title"),
                                     rs.getString("author"),
                                     rs.getDouble("price"));
            });
        return bookDTO;
    }

    @Override
    public String addBook(BookDTO book) {
        String sql="insert into book values(?,?,?,?,?)";
        List<BookDTO> allBooks = getAllBooks();
        int counter = allBooks.size();
        int update = jdbcTemplate.update(sql, new Object[]{++counter, book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice()});
        return String.valueOf(update);
    }

    @Override
    public int deleteBook(int id) {
        String sql = "delete from book where id=?";
        return jdbcTemplate.update(sql);
    }

    @Override
    public String updateBook(int id, BookDTO book) {
        String sql="update book set isbn=?,title=?, author=? ,price=? where id=?";
        int update = jdbcTemplate.update(sql, new Object[]{book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice()});
        return String.valueOf(update);
    }

    @Override
    public BookDTO getBookById(int id) {
        BookDTO b = new BookDTO();
        String sql = "select * from book where id=?";
        List<BookDTO> bookDTOS = jdbcTemplate.query(sql, (rs, i) -> {
            return new BookDTO(rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getDouble("price"));
        });
        for (BookDTO bb :bookDTOS ){
            b.setId(b.getId());
            b.setIsbn(b.getIsbn());
            b.setAuthor(b.getAuthor());
            b.setTitle(b.getTitle());
            b.setPrice(b.getPrice());
        }
        return b;
    }
}
