package com.lesha.repository;

import com.lesha.config.DatabaseConnection;
import com.lesha.Person;
import com.lesha.config.PostgresStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    PostgresStatement postgresStatement = new PostgresStatement();

    public UserRepository() throws SQLException {
    }
    //добавление человека в бд
    //удаление человека из бд

    public void addNewPerson(String email, String password, Person person) throws SQLException {
        String sql = "INSERT INTO  users(email, password, name, age, phone_number, work) VALUES ('" + email + "', '" + password + "', '" + person.getName() + "', '" + person.getAge() + "', '" + person.getPhone() + "', '" + person.getWork() + "')";
        postgresStatement.getStatement().execute(sql);
        //postgresStatement.getStatement().close();
    }

    public List<String> writeInformationToStringList(String column_name) throws SQLException {
        List<String> list = new ArrayList<>();
        String sql = "SELECT * FROM base_information";
        ResultSet result = postgresStatement.getStatement().executeQuery(sql);
        while (result.next()){
            list.add(result.getString(column_name));
        }
        return list;
    }

    public List<Person> writeInformationToPersonList() throws SQLException {
        List <Person> list = new ArrayList<>();
        String sql = "SELECT * FROM users";
        ResultSet resultSet = postgresStatement.getStatement().executeQuery(sql);
        while (resultSet.next()){
            list.add(new Person(resultSet.getString("name"),resultSet.getInt("age"),resultSet.getString("phone_number"),resultSet.getString("work")));
        }
        return list;
    }

    public void deletePersonById(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = '" + id + "'";
        postgresStatement.getStatement().execute(sql);
        //postgresStatement.getStatement().close();
    }

    public int foundPersonByEmail(String emailPerson) throws SQLException {;
        String sql = "SELECT * FROM users WHERE email = '" + emailPerson + "'";
        ResultSet result = postgresStatement.getStatement().executeQuery(sql);
        String email,password;
        int id = 0;
        while (result.next()){
            id = result.getInt("id");
        }
        return id;
    }

    public String getPasswordById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = '" + id + "'";
        ResultSet resultSet = postgresStatement.getStatement().executeQuery(sql);
        String password = null;
        while (resultSet.next()){
            password = resultSet.getString("password");
        }
        return password;
    }

}
