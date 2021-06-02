package xyz.auriium.beetle.task.sync;

import java.util.concurrent.Executor;

/**
 * Represents a synchronous infinitely looping queue that can have things added to it
 */
public interface SyncQueue extends Executor {


    /**
     * Runs all existing runnables
     */
    void pulseQueue();

}
