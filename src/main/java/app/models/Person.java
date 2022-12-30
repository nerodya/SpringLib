package app.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {

    private int id_person;

    @Min(value = 1900, message = "Некорректный год рождения")
    private int year_birth;

    @Pattern(regexp = "^([А-Я][а-я]+) ([А-Я][а-я]+) ([А-Я][а-я]+)$", message = "РеГуЛяРоЧкА")
    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Слишком короткое или длинное ФИО")
    private String name;

    public Person(int id_person, int year_birth, String name) {
        this.id_person = id_person;
        this.year_birth = year_birth;
        this.name = name;
    }

    public Person() {}

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public int getYear_birth() {
        return year_birth;
    }

    public void setYear_birth(int year_birth) {
        this.year_birth = year_birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
