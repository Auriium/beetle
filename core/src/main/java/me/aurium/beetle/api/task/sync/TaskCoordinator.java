package me.aurium.beetle.api.task.sync;

import me.aurium.beetle.api.task.TaskFuture;

import java.util.concurrent.TimeUnit;

public interface TaskCoordinator {

    boolean isMainThread();

    <T> T waitFor(TaskFuture<T> future);
    <T> T waitFor(TaskFuture<T> future, TimeUnit unit, long amount);

}
