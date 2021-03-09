package me.aurium.beetle.api.task;

/**
 * Represents a synchronous infinitely looping queue that can have things added to it
 */
public interface TaskQueue {

    /**
     * Adds something to the queue
     * @param runnable a runnable
     */
    void add(Runnable runnable);

    /**
     * Runs all existing runnables
     */
    void tick();

}
