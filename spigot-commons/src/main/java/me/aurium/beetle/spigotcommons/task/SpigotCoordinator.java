package me.aurium.beetle.spigotcommons.task;

import me.aurium.beetle.api.task.sync.SyncExecutorProvider;
import me.aurium.beetle.api.task.sync.coordination.BlockingBehavior;
import me.aurium.beetle.defaults.task.sync.AbstractThreadCoordinator;
import org.bukkit.Server;

public class SpigotCoordinator extends AbstractThreadCoordinator {

    private final Server server;

    public SpigotCoordinator(BlockingBehavior behavior, SyncExecutorProvider provider, Server server) {
        super(behavior, provider);
        this.server = server;
    }

    @Override
    public boolean isMainThread() {
        return server.isPrimaryThread();
    }
}
