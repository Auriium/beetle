package me.aurium.beetle.core.datacore;

import me.aurium.beetle.core.runner.TaskRunner;

/**
 * Something that can produce DataCores from CoreSources.
 */
public interface DataCoreFactory {

    DataCore produceDatacore(CoreSource source);
    DataCore produceDatacoreWithRunner(CoreSource source, TaskRunner runner);

}
