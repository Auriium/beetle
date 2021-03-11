package me.aurium.beetle.spigot;

import me.aurium.beetle.api.task.TaskQueue;
import me.aurium.beetle.api.task.Runner;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * TODO: let taskrunner use the queue
 */
public class SpigotRunner implements Runner {

    private final JavaPlugin plugin;
    private final TaskQueue queue;

    SpigotRunner(JavaPlugin plugin, TaskQueue queue) {
        this.plugin = plugin;
        this.queue = queue;
    }

    @Override
    public void runRunnableSync(Runnable runnable) {
        plugin.getServer().getScheduler().runTask(plugin,runnable);
    }

    @Override
    public void runRunnableAsync(Runnable runnable) {
        plugin.getServer().getScheduler().runTaskAsynchronously(plugin,runnable);
    }

    //todo: platform specific executor: get executor from the scheduler
    @Override
    public <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
       return CompletableFuture.supplyAsync(supplier);
    }


}
