package com.lesha.repository;

import com.lesha.DatabaseConnection;
import com.lesha.Person;

import java.sql.*;

public class UserRepository {
    Connection connection =  DatabaseConnection.connect();

    public UserRepository() throws SQLException {
    }
    //добавление человека в бд
    //удаление человека из бд


    public void addNewPerson(String email, String password) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("SET search_path TO my_shema");
        String sql = "INSERT INTO  base_information(email, password) VALUES ('" + email + "', '" + password + "')";
        statement.execute(sql);
    }

    public void deletePersonById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("SET search_path TO my_shema");
        String sql = "DELETE FROM base_information WHERE id = '" + id + "'";
        statement.execute(sql);
    }

    public int foundPersonByEmail(String emailPerson) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("SET search_path TO my_shema");
        String sql = "SELECT * FROM base_information WHERE email = '" + emailPerson + "'";
        ResultSet result = statement.executeQuery(sql);
        String email,password;
        int id = 0;
        while (result.next()){
            id = result.getInt("id");
        }
        return id;
    }

    public String getPasswordById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("SET search_path TO my_shema");
        String sql = "SELECT * FROM base_information WHERE id = '" + id + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        String password = null;
        while (resultSet.next()){
            password = resultSet.getString("password");
        }
        return password;
    }

}
