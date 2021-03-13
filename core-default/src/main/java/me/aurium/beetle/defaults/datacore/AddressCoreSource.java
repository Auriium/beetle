package me.aurium.beetle.defaults.datacore;

import me.aurium.beetle.api.datacore.CoreSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Deprecated
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

    @Override
    public DataSource getAdapter() {
        return null;
    }
}
