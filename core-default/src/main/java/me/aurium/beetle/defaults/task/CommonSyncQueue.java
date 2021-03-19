package me.aurium.beetle.defaults.task;

import me.aurium.beetle.api.task.SyncQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CommonSyncQueue implements SyncQueue {

    ConcurrentLinkedQueue<Runnable> runnableQueue = new ConcurrentLinkedQueue<>();

    @Override
    public void tick() {
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
