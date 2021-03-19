package me.aurium.beetle.defaults.datacore;

import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.api.datacore.DataCore;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.task.TaskRunner;

public class CommonDatacoreFactory implements DataCoreFactory {

    private final TaskRunner taskRunner;

    public CommonDatacoreFactory(TaskRunner taskRunner) {
        this.taskRunner = taskRunner;
    }

    @Override
    public DataCore produceDatacore(CoreSource source) {
        return new CommonDatacore(source, taskRunner);
    }

    @Override
    public DataCore produceDatacoreWithRunner(CoreSource source, TaskRunner taskRunner) {
        return new CommonDatacore(source, taskRunner);
    }


}
