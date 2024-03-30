package com.razz.DIusingjavaconfiguraiton.dao;

import com.razz.DIusingjavaconfiguraiton.dto.BookDTO;
import com.razz.DIusingjavaconfiguraiton.utils.JDBCConn;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component(value = "bookDao")
public class BookDaoPlainJDBCImpl implements BookDao {

    private  Connection conn = null;
    private PreparedStatement preparedStatement = null;


    @Override
    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookDTO = new ArrayList<>();
        try {
            conn = JDBCConn.getConn();
            preparedStatement = conn.prepareStatement("select * from book");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                bookDTO.add(new BookDTO(rs.getInt("id"),
                                        rs.getString("isbn"),
                                        rs.getString("title"),
                                        rs.getString("author"),
                                        rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                preparedStatement.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return bookDTO;
    }

    @Override
    public String addBook(BookDTO book) {
        String sql="insert into book values(?,?,?,?,?)";
        List<BookDTO> allBooks = getAllBooks();
        int counter = allBooks.size();
       String message = null;
        try {
            conn = JDBCConn.getConn();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,++counter);
            preparedStatement.setString(2,book.getIsbn());
            preparedStatement.setString(3,book.getTitle());
            preparedStatement.setString(4,book.getAuthor());
            preparedStatement.setDouble(5,book.getPrice());
            int count = preparedStatement.executeUpdate();
            if(count>0){
                message = String.format("Successfully updated {} records",count);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return message;
    }

    @Override
    public int deleteBook(int id) {
        String sql = "delete from book where id=?";
        int deleted = 0;
        conn = JDBCConn.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            deleted = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleted;
    }

    @Override
    public String updateBook(int id, BookDTO book) {
        String sql="update book set isbn=?,title=?, author=? ,price=? where id=?";
        List<BookDTO> allBooks = getAllBooks();
        String message = null;
        try {
            conn = JDBCConn.getConn();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,book.getIsbn());
            preparedStatement.setString(2,book.getTitle());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setDouble(4,book.getPrice());
            preparedStatement.setInt(5,id);

            int count = preparedStatement.executeUpdate();
            if(count>0){
                message = String.format("Successfully updated {} records",count);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return message;
    }

    @Override
    public BookDTO getBookById(int id) {
        String sql = "select * from book where id=?";
        BookDTO bookDTO = null;
        conn = JDBCConn.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bookDTO = new BookDTO(rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookDTO;
    }
}
