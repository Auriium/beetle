package xyz.auriium.beetle.task.impl.sync.util;

import xyz.auriium.beetle.task.sync.SyncPulser;
import xyz.auriium.beetle.task.sync.SyncQueue;

public class CommonSyncPulser implements SyncPulser {

    private final SyncQueue queue;

    public CommonSyncPulser(SyncQueue queue) {
        this.queue = queue;
    }

    public void pulse() {
        queue.pulseQueue();
    }
}
