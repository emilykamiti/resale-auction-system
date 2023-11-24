package com.resale.database;

import java.io.Serializable;
import java.sql.Connection;

import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MysqlDatabase implements Serializable {

    private static final String URL = "jdbc:mysql://localhost:3306/resale";

    private static final String USER = "root";

    private static final String PASSWORD = "nasinza2891";

    private static MysqlDatabase database;

    private Connection connection;

    private MysqlDatabase() throws SQLException {
      //  connection = DriverManager.getConnection(URL, USER, PASSWORD);
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);

        connection = dataSource.getConnection();
    }

    public static MysqlDatabase getInstance() throws SQLException {
        if (database == null)
            database = new MysqlDatabase();

        return database;

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
