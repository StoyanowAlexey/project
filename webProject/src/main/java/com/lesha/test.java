package com.lesha;

import com.lesha.repository.UserRepository;

import java.sql.*;

public class test {
    public static void isEmailExist(String email) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","31416");
        Statement statement = connection.createStatement();
        statement.execute("SET search_path TO my_shema");
        String sql = "SELECT EXISTS (SELECT 1 FROM base_information WHERE email = '" + email + "')";

        //return result;
    }
    public static void main(String [] args) throws SQLException {
        UserRepository userRepository = new UserRepository();
        int id = userRepository.foundPersonByEmail("lesha@gmail.com");
        System.out.println("id = " + id);
        String password = userRepository.getPasswordById(id);
        System.out.println("password = " + password);
        userRepository.deletePersonById(3);
    }
}
