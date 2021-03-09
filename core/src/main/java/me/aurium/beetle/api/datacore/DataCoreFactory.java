package me.aurium.beetle.api.datacore;

import me.aurium.beetle.api.task.TaskRunner;

/**
 * Something that can produce DataCores from CoreSources.
 */
public interface DataCoreFactory {

    DataCore produceDatacore(CoreSource source);
    DataCore produceDatacoreWithRunner(CoreSource source, TaskRunner runner);

}
