package me.aurium.beetle.defaults.datacore;

import me.aurium.beetle.api.datacore.CoreSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatasourceCoreSource implements CoreSource {

    private final DataSource source;

    DatasourceCoreSource(DataSource source) {
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
