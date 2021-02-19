package me.aurium.beetle.core.datacore;

import java.util.concurrent.CompletableFuture;

/**
 * Something that can.. do the stuff that dataloader does, suboptimally.
 *
 * Make sure that the constructor takes a DataSource and not a CoreSource!
 */
public interface DataCore {

    <R> CompletableFuture<R> runConsumer(TransactConsumer<R> consumer);

}
