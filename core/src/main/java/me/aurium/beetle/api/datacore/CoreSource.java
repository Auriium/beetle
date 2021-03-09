package me.aurium.beetle.api.datacore;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represents something that can produce connections that can be used by a DataCore.
 */
public interface CoreSource {

    Connection getConnection() throws SQLException;

}
