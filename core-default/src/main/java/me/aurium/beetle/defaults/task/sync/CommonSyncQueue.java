package me.aurium.beetle.defaults.task.sync;

import me.aurium.beetle.api.task.sync.SyncQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CommonSyncQueue implements SyncQueue {

    ConcurrentLinkedQueue<Runnable> runnableQueue = new ConcurrentLinkedQueue<>();

    @Override
    public void pulseQueue() {
        Runnable task;

        while ((task = runnableQueue.poll()) != null) {
            task.run();
        }
    }

    @Override
    public void execute(Runnable command) {
        runnableQueue.offer(command);
    }
}
