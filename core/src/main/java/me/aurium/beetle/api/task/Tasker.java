package me.aurium.beetle.api.task;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * Represents a tickable thing that can be launched that ticks it's taskqueue once launched
 */
public interface Tasker {

    Executor getSyncExecutor();
    Executor getAsyncExecutor();

    TaskRunner getRunner();
    void launch();

}
