package com.lesha.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresStatement {
    private Connection connection;
    private Statement statement;
    public PostgresStatement() throws SQLException {
        connection = DatabaseConnection.connect();
        statement =  connection.createStatement();
        statement.execute("SET search_path TO my_shema");
    }

    public Statement getStatement() {
        return statement;
    }
}
