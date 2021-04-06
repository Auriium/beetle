package me.aurium.beetle.defaults.datacore;

import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.api.datacore.DataCore;
import me.aurium.beetle.api.datacore.TransactConsumer;
import me.aurium.beetle.api.datacore.UncheckedSQLException;
import me.aurium.beetle.api.task.TaskRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

public class CommonDatacore implements DataCore {

    private final CoreSource source;
    private final TaskRunner taskRunner;

    CommonDatacore(CoreSource source, TaskRunner taskRunner) {
        this.source = source;
        this.taskRunner = taskRunner;
    }

    //TODO TransactProvider interface, separate class out a bit more, make ease of access system

    @Override
    public <R> CompletableFuture<R> runConsumer(TransactConsumer<R> consumer) {
        return taskRunner.supplyAsync(() -> {
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
                throw new UncheckedSQLException(ex);
            }
        });
    }

}
