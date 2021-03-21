package me.aurium.beetle.api.task.sync;

import me.aurium.beetle.api.task.ExecutorProvider;

import java.util.concurrent.Executor;

/**
 * lol
 */
public interface SyncExecutorProvider extends ExecutorProvider {

    /**
     * gets executor for the main thread. Since this is syncExecutorProvider it's a given there is a main thread.
     * @return executor
     */
    Executor getSyncExecutor();

}
