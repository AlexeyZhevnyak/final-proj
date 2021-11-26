package com.example.finalproj.dao;

import com.example.finalproj.Role;
import com.example.finalproj.model.IDao;
import com.example.finalproj.model.Programmer;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProgrammerDao implements IDao<Programmer> {

    private final Connection connection;

    public ProgrammerDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Programmer get(int id) {
        Programmer programmer = null;
        try (PreparedStatement prepareStatement = connection.prepareStatement(
                "select * from PROGRAMMER where ID = ?")) {
            prepareStatement.setInt(1, id);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                resultSet.next();
                programmer = new Programmer(
                    resultSet.getInt("ID"),
                    resultSet.getString("FIO"),
                    resultSet.getDate("birth").toLocalDate(),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    Role.valueOf(resultSet.getString("role"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programmer;
    }

    @Override
    public List<Programmer> getAll() {
        List<Programmer> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from PROGRAMMER")) {
            while (resultSet.next()) {
                list.add(new Programmer(
                    resultSet.getInt("ID"),
                    resultSet.getString("FIO"),
                    resultSet.getDate("birth").toLocalDate(),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    Role.valueOf(resultSet.getString("role"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Programmer programmer) {

    }

    @Override
    public void update(Programmer programmer) {

    }

    @Override
    public void delete(Programmer programmer) {

    }
}
