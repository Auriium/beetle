package me.aurium.beetle.core.datacore;

import me.aurium.beetle.core.task.TaskRunner;

/**
 * Something that can produce DataCores from CoreSources.
 */
public interface DataCoreFactory {

    DataCore produceDatacore(CoreSource source);
    DataCore produceDatacoreWithRunner(CoreSource source, TaskRunner runner);

}
