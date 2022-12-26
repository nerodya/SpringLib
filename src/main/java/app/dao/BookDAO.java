package app.dao;


import app.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void createBook(Book book){
        jdbcTemplate.update("insert into book(name_book, year, author) values (?, ?, ?)",
                book.getName_book(), book.getYear(), book.getAuthor());
    }

    public Book show(int id_book) {
        return jdbcTemplate.query("SELECT * FROM book where id_book=?", new Object[]{id_book}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }
}
