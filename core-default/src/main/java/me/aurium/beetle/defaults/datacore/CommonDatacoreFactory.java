package me.aurium.beetle.defaults.datacore;

import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.api.datacore.DataCore;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.task.TaskRunner;

public class CommonDatacoreFactory implements DataCoreFactory {

    private final TaskRunner runner;

    public CommonDatacoreFactory(TaskRunner runner) {
        this.runner = runner;
    }

    @Override
    public DataCore produceDatacore(CoreSource source) {
        return new CommonDatacore(source,runner);
    }

    @Override
    public DataCore produceDatacoreWithRunner(CoreSource source, TaskRunner runner) {
        return new CommonDatacore(source, runner);
    }


}
