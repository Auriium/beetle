package me.aurium.beetle.api.task.sync.coordination;

import me.aurium.beetle.api.task.futures.SyncTaskerFuture;

import java.util.concurrent.TimeUnit;

public interface TaskCoordinator {

    boolean isMainThread();

    <T> T waitFor(SyncTaskerFuture<T> future);
    <T> T waitFor(SyncTaskerFuture<T> future, TimeUnit unit, long amount);



}
