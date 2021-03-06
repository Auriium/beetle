package xyz.auriium.beetle.task.sync.coordination;

import xyz.auriium.beetle.task.futures.SyncTaskerFuture;
import xyz.auriium.beetle.task.sync.SyncPulser;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Represents something that can handle what to do when the main thread is being """blocked""" by a syncFuture
 *
 * ONLY SHOULD BE CALLED ON THE MAIN THREAD (please)
 */
public interface BlockingBehavior {

    <T> T waitForJoin(SyncTaskerFuture<T> future, SyncPulser pulser);
    <T> T waitForGet(SyncTaskerFuture<T> future, SyncPulser pulser) throws InterruptedException, ExecutionException;
    <T> T waitForTimer(SyncTaskerFuture<T> future, SyncPulser pulser, TimeUnit waitType, long waitDuration) throws InterruptedException, TimeoutException, ExecutionException;

}
