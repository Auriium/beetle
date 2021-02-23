package me.aurium.beetle.spigot;

import me.aurium.beetle.core.runner.TaskRunner;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class SpigotTaskRunner implements TaskRunner {

    private final JavaPlugin plugin;

    SpigotTaskRunner(JavaPlugin plugin) {
        this.plugin = plugin;
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
