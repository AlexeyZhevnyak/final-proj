package com.example.finalproj.dao;

import com.example.finalproj.Constants;
import com.example.finalproj.Role;
import com.example.finalproj.Status;
import com.example.finalproj.model.IDao;
import com.example.finalproj.model.Programmer;
import com.example.finalproj.model.Task;
import com.example.finalproj.service.ProgrammerService;

import org.springframework.beans.factory.annotation.Autowired;
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
public class TaskDaoDb implements IDao<Task> {

    private final ProgrammerService programmerService;
    private final Connection connection;

    public TaskDaoDb(Connection connection, ProgrammerService programmerService) {
        this.connection = connection;
        this.programmerService = programmerService;
    }

    @Override
    public Task get(int id) {
        Task task = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from TASK where ID = ?")) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    task = new Task(
                        resultSet.getInt("ID"),
                        resultSet.getInt("ID_PROJECT"),
                        resultSet.getString("TITLE"),
                        programmerService.get(resultSet.getInt("ID_PROG")),
                        resultSet.getDate("START_DATE").toLocalDate(),
                        resultSet.getDate("END_DATE").toLocalDate(),
                        Status.valueOf(resultSet.getString("STATUS")),
                        resultSet.getString("COMMENTS")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public List<Task> getAll() {
        List<Task> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Constants.SELECT_ALL_TASKS)) {
            while (resultSet.next()) {
                list.add(new Task(
                    resultSet.getInt("ID"),
                    resultSet.getInt("ID_PROJECT"),
                    resultSet.getString("TITLE"),
                    programmerService.get(resultSet.getInt("ID_PROG")),
                    resultSet.getDate("START_DATE").toLocalDate(),
                    resultSet.getDate("END_DATE").toLocalDate(),
                    Status.valueOf(resultSet.getString("STATUS")),
                    resultSet.getString("COMMENTS")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Task task) {

    }

    @Override
    public void update(Task task) {
        try (PreparedStatement prepareStatement = connection.prepareStatement(
            "UPDATE TASK SET ID_PROJECT = ?, TITLE = ?, ID_PROG = ?, START_DATE = ?, END_DATE = ?, STATUS = ?, COMMENTS = ? WHERE ID = ?");) {
            prepareStatement.setInt(1, task.getProjectID());
            prepareStatement.setString(2, task.getTitle());
            prepareStatement.setInt(3, task.getExecutor().getId());
            prepareStatement.setDate(4, Date.valueOf(task.getBegin()));
            prepareStatement.setDate(5, Date.valueOf(task.getEnd()));
            prepareStatement.setString(6, task.getStatus().name());
            prepareStatement.setString(7, task.getComments());
            prepareStatement.setInt(8, task.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Task task) {

    }
}
