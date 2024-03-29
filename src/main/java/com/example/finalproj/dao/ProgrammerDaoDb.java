package com.example.finalproj.dao;

import com.example.finalproj.Constants;
import com.example.finalproj.Role;
import com.example.finalproj.model.IDao;
import com.example.finalproj.model.Programmer;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProgrammerDaoDb implements IDao<Programmer> {

    private final Connection connection;

    public ProgrammerDaoDb(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Programmer get(int id) {
        Programmer programmer = null;
        try (PreparedStatement prepareStatement = connection.prepareStatement(
            Constants.SELECT_PROGRAMMER_BY_ID)) {
            prepareStatement.setInt(Constants.PROGRAMMER_ID_INDEX, id);
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
             ResultSet resultSet = statement.executeQuery(Constants.SELECT_ALL_PROGRAMMERS)) {
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
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into PROGRAMMER (FIO, BIRTH, LOGIN, PASSWORD, EMAIL, ROLE) values ( ?,?,?,?,?,? )")){
            preparedStatement.setString(1,programmer.getFIO());
            preparedStatement.setDate(2,Date.valueOf(programmer.getBirthDate()));
            preparedStatement.setString(3,programmer.getLogin());
            preparedStatement.setString(4,programmer.getPassword());
            preparedStatement.setString(5,programmer.getEmail());
            preparedStatement.setString(6,programmer.getRole().name());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Programmer programmer) {
        try (PreparedStatement prepareStatement = connection.prepareStatement(
            "UPDATE PROGRAMMER SET BIRTH = ?, EMAIL = ?, FIO = ?, LOGIN = ?, PASSWORD = ?, ROLE = ? WHERE ID = ?");) {
            prepareStatement.setDate(1, Date.valueOf(programmer.getBirthDate()));
            prepareStatement.setString(2, programmer.getEmail());
            prepareStatement.setString(3, programmer.getFIO());
            prepareStatement.setString(4, programmer.getLogin());
            prepareStatement.setString(5, programmer.getPassword());
            prepareStatement.setString(6, programmer.getRole().name());
            prepareStatement.setInt(7, programmer.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Programmer programmer) {

    }
}
