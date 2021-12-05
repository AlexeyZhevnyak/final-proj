package com.example.finalproj.model;

import com.example.finalproj.Role;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Programmer {
    private int id;
    private String FIO;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private String password;
    private String email;
    private Role role;
    private String login;

    public Programmer(int id, String FIO, LocalDate birthDate, String login, String password, String email, Role role) {
        this.id = id;
        this.FIO = FIO;
        this.birthDate = birthDate;
        this.password = password;
        this.email = email;
        this.role = role;
        this.login = login;
    }

    public Programmer() {
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Programmer that = (Programmer) o;
        return id == that.id && Objects.equals(FIO, that.FIO) && Objects.equals(birthDate,
            that.birthDate) && Objects.equals(password, that.password) && Objects.equals(email,
            that.email) && role == that.role && Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FIO, birthDate, password, email, role, login);
    }

    @Override
    public String toString() {
        return "Programmer{" +
            "id=" + id +
            ", FIO='" + FIO + '\'' +
            ", birthDate=" + birthDate +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", role=" + role +
            ", login='" + login + '\'' +
            '}';
    }
}
