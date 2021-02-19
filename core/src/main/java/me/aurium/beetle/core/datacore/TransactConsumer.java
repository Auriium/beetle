package me.aurium.beetle.core.datacore;

@FunctionalInterface
public interface TransactConsumer<R> {

    R consume(Transact transact);

}
