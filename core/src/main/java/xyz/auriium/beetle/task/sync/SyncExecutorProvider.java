package xyz.auriium.beetle.task.sync;

import xyz.auriium.beetle.task.ExecutorProvider;

/**
 * lol
 */
public interface SyncExecutorProvider extends ExecutorProvider, AutoCloseable {

    /**
     * gets executor for the main thread. Since this is syncExecutorProvider it's a given there is a main thread.
     * @return executor
     */
    SyncQueue getSyncExecutor();

    /**
     * Activate threaded resync loop
     */
    void launch();

}
