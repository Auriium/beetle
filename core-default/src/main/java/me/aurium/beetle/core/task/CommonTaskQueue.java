package me.aurium.beetle.core.task;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CommonTaskQueue implements TaskQueue {

    ConcurrentLinkedQueue<Runnable> runnableQueue = new ConcurrentLinkedQueue<>();

    @Override
    public void add(Runnable runnable) {
        runnableQueue.offer(runnable);
    }

    @Override
    public void tick() {
        Runnable task;

        while ((task = runnableQueue.poll()) != null) {
            task.run();
        }
    }
}
