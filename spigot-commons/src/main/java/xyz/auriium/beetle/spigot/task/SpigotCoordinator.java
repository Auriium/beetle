package xyz.auriium.beetle.spigot.task;

import org.bukkit.Server;
import xyz.auriium.beetle.task.impl.sync.AbstractThreadCoordinator;
import xyz.auriium.beetle.task.sync.SyncExecutorProvider;
import xyz.auriium.beetle.task.sync.coordination.BlockingBehavior;

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
