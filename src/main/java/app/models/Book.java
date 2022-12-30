package app.models;




import org.springframework.web.bind.annotation.PathVariable;

import java.lang.invoke.DelegatingMethodHandle$Holder;
import java.time.LocalDate;
import javax.validation.constraints.*;



public class Book {

    private int id_book;
    private Integer id_person;

    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Слишком короткое или длинное название")
    private String name_book;

    @Max(value = 2023, message = "Некорректный год")
    @Min(value = 0, message = "Некорректный год")
    private int year;

    @Pattern(regexp = "^([А-Я][а-я]+) ([А-Я][а-я]+) ([А-Я][а-я]+)$", message = "РеГуЛяРоЧкА")
    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Слишком короткое или длинное ФИО")
    private String author;


    public Book(int id_book, Integer id_person, String name_book,  int year, String author) {
        this.id_book = id_book;
        this.id_person = id_person;
        this.name_book = name_book;
        this.author = author;
        this.year = year;
    }

    public Book(){};

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public Integer getId_person() {
        return (id_person);
    }

    public void setId_person(Integer id_person) {
        this.id_person = id_person;
    }
}
