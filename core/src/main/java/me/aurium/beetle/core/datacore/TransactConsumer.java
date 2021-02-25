package me.aurium.beetle.core.datacore;

import java.sql.SQLException;

/**
 * Functional interface that can consume a transaction and interact
 * @param <R> the transaction
 */
@FunctionalInterface
public interface TransactConsumer<R> {

    R consume(Transact transact) throws SQLException;

}
