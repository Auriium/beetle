package me.aurium.beetle.core.datacore;

import me.aurium.beetle.core.runner.TaskRunner;

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
