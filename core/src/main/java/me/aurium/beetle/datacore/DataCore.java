package me.aurium.beetle.datacore;

import java.util.concurrent.CompletableFuture;

/**
 * Something that can run a TransactConsumer functional interface. Usually used to do transactions to the linked database asynchronously.
 */
public interface DataCore {

    <R> CompletableFuture<R> runConsumer(TransactConsumer<R> consumer);

}
