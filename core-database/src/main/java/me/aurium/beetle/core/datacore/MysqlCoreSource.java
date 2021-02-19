package me.aurium.beetle.core.datacore;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MysqlCoreSource implements CoreSource{

    private final DataSource source;

    MysqlCoreSource(DataSource source) {
        this.source = source;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return source.getConnection();
    }
}
