package me.aurium.beetle.api.task.sync;

import java.util.concurrent.Executor;

/**
 * Represents a synchronous infinitely looping queue that can have things added to it
 */
public interface SyncQueue {


    /**
     * Runs all existing runnables
     */
    void pulseQueue();

}
