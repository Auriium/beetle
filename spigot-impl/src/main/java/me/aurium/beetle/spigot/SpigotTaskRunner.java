package me.aurium.beetle.spigot;

import me.aurium.beetle.api.task.TaskQueue;
import me.aurium.beetle.api.task.TaskRunner;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * TODO: let taskrunner use the queue
 */
public class SpigotTaskRunner implements TaskRunner {

    private final JavaPlugin plugin;
    private final TaskQueue queue;

    SpigotTaskRunner(JavaPlugin plugin, TaskQueue queue) {
        this.plugin = plugin;
        this.queue = queue;
    }

    @Override
    public void runTaskSync(Runnable runnable) {
        plugin.getServer().getScheduler().runTask(plugin,runnable);
    }

    @Override
    public void runTaskAsync(Runnable runnable) {
        plugin.getServer().getScheduler().runTaskAsynchronously(plugin,runnable);
    }

    //todo: platform specific executor: get executor from the scheduler
    @Override
    public <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
       return CompletableFuture.supplyAsync(supplier);
    }


}
