package me.aurium.beetle.api.task.sync.coordination;

import me.aurium.beetle.api.task.futures.SyncTaskerFuture;
import me.aurium.beetle.api.task.futures.TaskFuture;
import me.aurium.beetle.api.task.sync.SyncPulser;

import java.util.concurrent.TimeUnit;

/**
 * Represents something that can handle what to do when the main thread is being """blocked""" by a syncFuture
 *
 * ONLY SHOULD BE CALLED ON THE MAIN THREAD (please)
 */
public interface BlockingBehavior {

    <T> T waitFor(SyncTaskerFuture<T> future, SyncPulser pulser);
    <T> T waitFor(SyncTaskerFuture<T> future, SyncPulser pulser, TimeUnit waitType, long waitDuration);

}
