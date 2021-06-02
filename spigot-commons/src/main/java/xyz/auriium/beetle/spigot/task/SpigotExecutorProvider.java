package xyz.auriium.beetle.spigot.task;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import xyz.auriium.beetle.task.impl.sync.util.CommonSyncQueue;
import xyz.auriium.beetle.task.sync.SyncExecutorProvider;
import xyz.auriium.beetle.task.sync.SyncQueue;

import java.util.concurrent.Executor;

public class SpigotExecutorProvider implements SyncExecutorProvider {

    private final SyncQueue queue = new CommonSyncQueue();

    private final JavaPlugin plugin;
    private final Executor asyncExecutor;

    private BukkitTask cancellable;

    public SpigotExecutorProvider(JavaPlugin plugin, Executor asyncExecutor) {
        this.plugin = plugin;
        this.asyncExecutor = asyncExecutor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncExecutor;
    }

    @Override
    public SyncQueue getSyncExecutor() {
        return queue;
    }

    @Override
    public void launch() {
        cancellable = plugin.getServer().getScheduler().runTaskTimer(plugin, queue::pulseQueue, 20L, 20L);
    }

    @Override
    public void close() {
        queue.execute(() -> cancellable.cancel());
    }
}
