package me.aurium.beetle.api.task.sync;

/**
 * Represents something that can handle what to do when the main thread is being """blocked""" by a syncFuture
 */
public interface BlockingBehavior {

    void behavior();

}
