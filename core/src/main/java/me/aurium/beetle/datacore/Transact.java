package me.aurium.beetle.datacore;

import java.sql.Connection;

/**
 * Light transactable object provided by a Datasource
 */
public interface Transact extends AutoCloseable {

    Connection getConnection();

}
