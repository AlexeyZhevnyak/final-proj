package com.example.finalproj;

public class Constants {
    public final static String DB_URL = "jdbc:h2:C:/Users/admin/test";
    public final static String DB_USER = "sa";
    public final static String DB_PASSWORD= "";
    public final static String SELECT_ALL_TASKS= "select * from TASK";
    public final static String SELECT_ALL_PROGRAMMERS= "select * from PROGRAMMER";
    public final static String SELECT_PROGRAMMER_BY_ID= "select * from PROGRAMMER where ID = ?";
    public final static String SELECT_PROJECT_BY_ID= "select * from PROJECT where ID = ?";
    public static final int PROGRAMMER_ID_INDEX = 1;
    public static final int PROJECT_ID_INDEX = 1;
    public static final String SELECT_ALL_PROJECTS = "select * from PROJECT";
}
