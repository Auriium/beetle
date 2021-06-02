package xyz.auriium.beetle.datacore;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represents something that can produce connections that can be used by a DataCore.
 */
public interface CoreSource {

    Connection getConnection() throws SQLException;

    DataSource getAdapter();

}
