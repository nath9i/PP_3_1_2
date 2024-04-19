package org.nath9i.pp3_1_2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Pattern(regexp = "[A-Z][a-z]+", message = "Name should consist of letters and start with a capital")
    @NotBlank(message = "Name is a required field")
    @Size(min = 2, max = 40, message = "Name length should be between 2 and 40 symbols")
    @Column(name = "first_name")
    private String name;

    @Pattern(regexp = "[A-Z][a-z]+", message = "Surname should consist of letters and start with a capital")
    @NotBlank(message = "Surname is a required field")
    @Size(min = 2, max = 40, message = "Surname length should be between 2 and 40 symbols")
    @Column(name = "surname")
    private String surname;

    @Min(value = 1, message = "Age should be greater than 0")
    @Max(value = 120, message = "I just can't believe that!")
    @Column(name = "age")
    private int age;

    public User(String name, String surname, byte age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
