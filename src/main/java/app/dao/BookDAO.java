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

    public void edit(Book book, int id) {
        jdbcTemplate.update("UPDATE book SET name_book=?, year=?, author=? WHERE id_book=?",
                book.getName_book(), book.getYear(), book.getAuthor(), id);
    }

    public void editClient(int id_book, int id_person) {
        jdbcTemplate.update("update book set id_person=? where id_book=?",
                id_person, id_book);
    }

    public void freeClient(Integer id) {
        jdbcTemplate.update("update book set id_person=null where id_book=?",
                id);
    }

    public List<Book> hasPerson(int id_person) {
        return jdbcTemplate.query("select * from book where id_person=?",
                new Object[]{id_person}, new BeanPropertyRowMapper<>(Book.class));
    }
}
