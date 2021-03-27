package me.aurium.beetle.spigotcommons.task;

import me.aurium.beetle.api.task.sync.SyncExecutorProvider;
import me.aurium.beetle.api.task.sync.SyncQueue;
import me.aurium.beetle.defaults.task.sync.util.CommonSyncQueue;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executor;

public class SpigotExecutorProvider implements SyncExecutorProvider {

    private final SyncQueue queue = new CommonSyncQueue();

    private final JavaPlugin plugin;
    private final Executor asyncExecutor;

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
        plugin.getServer().getScheduler().runTaskTimer(plugin, queue::pulseQueue, 20L, 20L);
    }


}
