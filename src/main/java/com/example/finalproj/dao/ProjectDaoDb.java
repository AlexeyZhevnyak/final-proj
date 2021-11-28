package com.example.finalproj.dao;

import com.example.finalproj.Constants;
import com.example.finalproj.ProjectStatus;
import com.example.finalproj.Role;
import com.example.finalproj.Status;
import com.example.finalproj.model.IDao;
import com.example.finalproj.model.Programmer;
import com.example.finalproj.model.Project;
import com.example.finalproj.model.Task;
import com.example.finalproj.service.ProgrammerService;
import com.example.finalproj.service.TaskService;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectDaoDb implements IDao<Project> {

    private final ProgrammerService programmerService;
    private final TaskService taskService;
    private final Connection connection;

    public ProjectDaoDb(ProgrammerService programmerService, TaskService taskService,
                        Connection connection) {
        this.programmerService = programmerService;
        this.taskService = taskService;
        this.connection = connection;
    }

    @Override
    public Project get(int id) {
        Project project = null;
        try (PreparedStatement prepareStatement = connection.prepareStatement(
            Constants.SELECT_PROJECT_BY_ID)) {
            prepareStatement.setInt(Constants.PROJECT_ID_INDEX, id);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                resultSet.next();
                int projectID = resultSet.getInt("ID");
                List<Task> tasks = taskService.getAll()
                    .stream()
                    .filter(t -> t.getProjectID() == projectID)
                    .collect(Collectors.toList());
                List<Programmer> programmers = tasks.stream()
                    .map(Task::getExecutor)
                    .distinct()
                    .collect(Collectors.toList());
                project = new Project(
                    resultSet.getInt("ID"),
                    tasks,
                    programmers,
                    ProjectStatus.valueOf(resultSet.getString("STATUS")),
                    resultSet.getInt("CREATORID"),
                    resultSet.getString("TITLE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public List<Project> getAll() {
        List<Project> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Constants.SELECT_ALL_PROJECTS)) {
            while (resultSet.next()) {
                int projectID = resultSet.getInt("ID");
                List<Task> tasks = taskService.getAll()
                    .stream()
                    .filter(t -> t.getProjectID() == projectID)
                    .collect(Collectors.toList());
                List<Programmer> programmers = tasks.stream()
                    .map(Task::getExecutor)
                    .distinct()
                    .collect(Collectors.toList());
                list.add(new Project(
                    resultSet.getInt("ID"),
                    tasks,
                    programmers,
                    ProjectStatus.valueOf(resultSet.getString("STATUS")),
                    resultSet.getInt("CREATORID"),
                    resultSet.getString("TITLE")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Project project) {

    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void delete(Project project) {

    }
}
