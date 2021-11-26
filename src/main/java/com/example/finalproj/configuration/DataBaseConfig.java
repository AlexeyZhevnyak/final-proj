package com.example.finalproj.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DataBaseConfig {
    private Connection connection;

//    public DataBaseConfig() {
//    }

    @Bean
    public Connection getDataSource() {
        if (connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:h2:C:/Users/admin/test", "sa", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
