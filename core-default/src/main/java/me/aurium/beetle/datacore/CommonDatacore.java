package me.aurium.beetle.datacore;

import me.aurium.beetle.task.TaskRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

public class CommonDatacore implements DataCore {

    private final CoreSource source;
    private final TaskRunner runner;

    CommonDatacore(CoreSource source, TaskRunner runner) {
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
                throw new UncheckedSQLException(ex);
            }
        });
    }

}
