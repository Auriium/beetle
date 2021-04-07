package me.aurium.beetle.defaults.task.sync.util;

import me.aurium.beetle.api.task.sync.SyncPulser;
import me.aurium.beetle.api.task.sync.SyncQueue;

public class CommonSyncPulser implements SyncPulser {

    private final SyncQueue queue;

    public CommonSyncPulser(SyncQueue queue) {
        this.queue = queue;
    }

    public void pulse() {
        queue.pulseQueue();
    }
}
