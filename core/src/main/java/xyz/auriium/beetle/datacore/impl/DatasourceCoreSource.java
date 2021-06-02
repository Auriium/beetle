package xyz.auriium.beetle.datacore.impl;

import xyz.auriium.beetle.datacore.CoreSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatasourceCoreSource implements CoreSource {

    private final DataSource source;

    public DatasourceCoreSource(DataSource source) {
        this.source = source;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    @Override
    public DataSource getAdapter() {
        return source;
    }
}
