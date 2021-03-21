package me.aurium.beetle.spigot;

import me.aurium.beetle.api.task.sync.BlockingBehavior;
import me.aurium.beetle.defaults.task.sync.MainThreadTasker;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executor;

public class SpigotTasker extends MainThreadTasker {

    private final JavaPlugin plugin;

    protected SpigotTasker(Thread thread, Executor asyncExecutor, BlockingBehavior behavior, JavaPlugin plugin) {
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
