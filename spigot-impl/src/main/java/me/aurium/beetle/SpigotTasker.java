package me.aurium.beetle;

import me.aurium.beetle.task.CommonTaskQueue;
import me.aurium.beetle.task.TaskQueue;
import me.aurium.beetle.task.TaskRunner;
import me.aurium.beetle.task.Tasker;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotTasker implements Tasker {

    private final TaskQueue queue;
    private final TaskRunner runner;
    private final JavaPlugin plugin;

    SpigotTasker(JavaPlugin plugin) {
        this.plugin = plugin;
        this.queue = new CommonTaskQueue();
        this.runner = new SpigotTaskRunner(plugin,queue);
    }

    @Override
    public TaskQueue getQueue() {
        return queue;
    }

    @Override
    public TaskRunner getRunner() {
        return runner;
    }

    @Override
    public void launch() {
        plugin.getServer().getScheduler().runTaskTimer(plugin,queue::tick,0L,1L);
    }
}
