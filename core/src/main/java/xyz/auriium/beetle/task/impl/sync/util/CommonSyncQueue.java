package xyz.auriium.beetle.task.impl.sync.util;

import xyz.auriium.beetle.task.sync.SyncQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CommonSyncQueue implements SyncQueue {

    private final ConcurrentLinkedQueue<Runnable> runnableQueue = new ConcurrentLinkedQueue<>();

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
