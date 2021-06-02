package xyz.auriium.beetle.datacore.impl;

import xyz.auriium.beetle.datacore.Transact;

import java.sql.Connection;

public class SQLTransact implements Transact {

    private final Connection connection;

    public SQLTransact(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public <T> T getProperty(Class<T> tClass) {
        if (tClass.equals(Connection.class)) {
            return (T) connection;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
