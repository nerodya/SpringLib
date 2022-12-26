package app.dao;

import app.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id_person) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id_person=?", new Object[]{id_person}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void createPerson(Person person) {
        jdbcTemplate.update("INSERT INTO Person(name, year_birth) VALUES (?, ?)",
                person.getName(), person.getYear_birth());
    }

    public void update(Person person, int id) {
        jdbcTemplate.update("UPDATE Person SET name=?, year_birth=? WHERE id_person=?",
                person.getName(), person.getYear_birth(), id);
    }
}
