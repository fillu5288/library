package org.mksmv.Library.dao;

import org.mksmv.Library.models.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BooksDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Books> index() {
        return jdbcTemplate.query("SELECT * FROM books",
                new BeanPropertyRowMapper<>(Books.class));
    } // получение данных

    public Books info(int id) {
        return jdbcTemplate.query("SELECT * FROM books WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Books.class)).stream().findAny().orElse(null);
    }

    public void save(Books books) {
        jdbcTemplate.update("INSERT INTO books(naming, creator, year) VALUES(?, ?, ?)",
                books.getNaming(), books.getCreator(), books.getYear());
    }

    public void update(int id, Books updatedBooks) {
        jdbcTemplate.update("UPDATE books SET naming=?, creator=?, year=? WHERE id=?",
                updatedBooks.getNaming(), updatedBooks.getCreator(), updatedBooks.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM books WHERE id=?", id);
    }
}

