package xyz.auriium.beetle.datacore.impl;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class AddressDataSource implements DataSource {

    private final String address;
    private final String username;
    private final String password;
    private int timeout;

    AddressDataSource(String address, String username, String password, int timeout) {
        this.address = address;
        this.username = username;
        this.password = password;
        this.timeout = timeout;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(address,username,password);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(address,username,password);
    }

    @Override
    public PrintWriter getLogWriter() {
        throw new UnsupportedOperationException("No logwriter for AddressDataSource!");
    }

    @Override
    public void setLogWriter(PrintWriter out) {
        throw new UnsupportedOperationException("No logwriter for AddressDataSource");
    }

    @Override
    public void setLoginTimeout(int seconds) {
        this.timeout = seconds;
    }

    @Override
    public int getLoginTimeout() {
        return timeout;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        try {
            if (isWrapperFor(iface)) {
                return iface.cast(this);
            } else {
                throw new SQLException(
                        "The receiver is not a wrapper and does not implement the interface");
            }
        } catch (Exception e) {
            throw new SQLException("The receiver is not a wrapper and does not implement the interface");
        }
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) {
        return iface.isInstance(this);
    }
}
