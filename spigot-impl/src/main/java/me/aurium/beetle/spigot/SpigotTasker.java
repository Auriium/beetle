package me.aurium.beetle.spigot;

import me.aurium.beetle.defaults.task.AbstractTasker;
import me.aurium.beetle.defaults.task.CommonSyncQueue;
import me.aurium.beetle.api.task.SyncQueue;
import me.aurium.beetle.api.task.TaskRunner;
import me.aurium.beetle.api.task.Tasker;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class SpigotTasker extends AbstractTasker {


    private final JavaPlugin plugin;
    public SpigotTasker(Executor service, JavaPlugin plugin) {
        super(service);

        this.plugin = plugin;
    }

    @Override
    public void launch() {
        plugin.getServer().getScheduler().runTaskTimer(plugin, asQueue()::tick,0L,1L);
    }
}
