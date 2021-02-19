package me.aurium.beetle.core.datacore;

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
    public void close() throws Exception {
        connection.close();
    }
}
