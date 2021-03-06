package me.aurium.beetle.datacore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AddressCoreSource implements CoreSource {

    private final String address;
    private String username;
    private String password;

    AddressCoreSource(String address, String username, String password) {
        this.address = address;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(address,username,password);
    }
}
