package me.aurium.beetle.spigot;

import me.aurium.beetle.core.datacore.CoreSource;
import me.aurium.beetle.core.datacore.DataCore;
import me.aurium.beetle.core.datacore.DataCoreFactory;
import me.aurium.beetle.core.runner.TaskRunner;

public class SpigotDatacoreFactory implements DataCoreFactory {

    private final TaskRunner runner;

    SpigotDatacoreFactory(TaskRunner runner) {
        this.runner = runner;
    }

    @Override
    public DataCore produceDatacore(CoreSource source) {
        return new SpigotDatacore(source,runner);
    }

    @Override
    public DataCore produceDatacoreWithRunner(CoreSource source, TaskRunner runner) {
        return new SpigotDatacore(source, runner);
    }


}
