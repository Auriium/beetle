package me.aurium.beetle.defaults.datacore;

import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.api.datacore.DataCore;
import me.aurium.beetle.api.datacore.DataCoreFactory;
import me.aurium.beetle.api.task.Runner;

public class CommonDatacoreFactory implements DataCoreFactory {

    private final Runner runner;

    public CommonDatacoreFactory(Runner runner) {
        this.runner = runner;
    }

    @Override
    public DataCore produceDatacore(CoreSource source) {
        return new CommonDatacore(source,runner);
    }

    @Override
    public DataCore produceDatacoreWithRunner(CoreSource source, Runner runner) {
        return new CommonDatacore(source, runner);
    }


}
