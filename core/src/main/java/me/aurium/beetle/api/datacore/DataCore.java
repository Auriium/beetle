package me.aurium.beetle.api.datacore;

import java.util.concurrent.CompletableFuture;

/**
 * Something that can run a TransactConsumer functional interface. Usually used to do transactions to the linked database asynchronously.
 */
public interface DataCore {

    CompletableFuture<Void> runAction(TransactAction action);
    <R> CompletableFuture<R> runConsumer(TransactConsumer<R> consumer);

}
