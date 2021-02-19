package me.aurium.beetle.core.datacore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteCoreSource implements CoreSource {

    private final String address;
    private final String username;
    private final String password;

    SQLiteCoreSource(String address, String username, String password) {
        this.address = address;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(address,username,password);
    }
}
