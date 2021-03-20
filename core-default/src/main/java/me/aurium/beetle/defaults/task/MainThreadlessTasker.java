package me.aurium.beetle.defaults.task;

import me.aurium.beetle.api.task.TaskRunner;
import me.aurium.beetle.api.task.Tasker;
import me.aurium.beetle.api.util.NotImplementedException;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class MainThreadlessTasker implements Tasker {

    private final ExecutorService asyncExecutor;
    private final TaskRunner runner;

    public MainThreadlessTasker(ExecutorService asyncExecutor) {
        this.asyncExecutor = asyncExecutor;

        this.runner = new MainThreadlessRunner(asyncExecutor);
    }


    @Override
    public Executor getSyncExecutor() {
         throw new NotImplementedException("no main thread!");
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncExecutor;
    }

    @Override
    public TaskRunner getRunner() {
        return runner;
    }

    @Override
    public void launch() {
        //noops
    }
}
