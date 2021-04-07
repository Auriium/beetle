package me.aurium.beetle.api.task.sync.coordination;

import me.aurium.beetle.api.task.futures.SyncTaskerFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface TaskCoordinator {

    boolean isMainThread();

    <T> T waitForJoin(SyncTaskerFuture<T> future);
    <T> T waitForGet(SyncTaskerFuture<T> future) throws InterruptedException, ExecutionException;
    <T> T waitForTimer(SyncTaskerFuture<T> future, TimeUnit waitType, long waitDuration) throws InterruptedException, TimeoutException, ExecutionException;



}
