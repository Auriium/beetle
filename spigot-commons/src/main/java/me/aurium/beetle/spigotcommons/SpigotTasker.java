package me.aurium.beetle.spigotcommons;

import me.aurium.beetle.api.task.sync.TaskCoordinator;
import me.aurium.beetle.defaults.task.sync.MainThreadTasker;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executor;

public class SpigotTasker extends MainThreadTasker {

    private final JavaPlugin plugin;

    public SpigotTasker(Thread thread, Executor asyncExecutor, TaskCoordinator behavior, JavaPlugin plugin) {
        super(thread, asyncExecutor, behavior);

        this.plugin = plugin;
    }

    @Override
    public void launch() {
        plugin.getServer().getScheduler().runTaskTimer(plugin,() -> {
            getQueue().pulseQueue();
        },10L,10L);
    }
}
