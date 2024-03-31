package com.razz.DIusingjavaconfiguraiton.dao;

import com.razz.DIusingjavaconfiguraiton.dto.BookDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountRowMapper implements RowMapper<BookDTO> {
    @Override
    public BookDTO mapRow(ResultSet rs, int i) throws SQLException {
        return  new BookDTO(rs.getInt("id"),
                rs.getString("isbn"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getDouble("price"));
    }
}
