package me.aurium.beetle.core.datacore;

import java.sql.Connection;

/**
 * Light transactable object provided by a Datasource
 */
public interface Transact extends AutoCloseable {

    Connection getConnection();

}
