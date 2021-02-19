package me.aurium.beetle.spigot;

import me.aurium.beetle.core.datacore.CoreSource;
import me.aurium.beetle.core.datacore.DataCore;
import me.aurium.beetle.core.datacore.SQLTransact;
import me.aurium.beetle.core.datacore.TransactConsumer;
import me.aurium.beetle.core.runner.TaskRunner;
import me.aurium.beetle.core.utility.exception.UnchektSQLException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

public class SpigotDatacore implements DataCore {

    private final CoreSource source;
    private final TaskRunner runner;

    SpigotDatacore(CoreSource source, TaskRunner runner) {
        this.source = source;
        this.runner = runner;
    }

    @Override
    public <R> CompletableFuture<R> runConsumer(TransactConsumer<R> consumer) {
        return runner.supplyAsync(() -> {
            try (Connection connection = source.getConnection()) {
                SQLTransact transaction = new SQLTransact(connection);

                R value;
                try {
                    value = consumer.consume(transaction); //wow such copy/paste
                } catch (RuntimeException ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException suppressed) {
                        ex.addSuppressed(suppressed);
                    }
                    throw ex;
                }

                //manually commit
                connection.commit();
                return value;

            } catch (SQLException ex) {
                throw new UnchektSQLException(ex);
            }
        });
    }
}
