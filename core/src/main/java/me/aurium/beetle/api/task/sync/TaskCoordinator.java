package me.aurium.beetle.api.task.sync;

import me.aurium.beetle.api.task.TaskFuture;

public interface TaskCoordinator {

    boolean isMainThread();

    <T> T waitFor(TaskFuture<T> future);

}
