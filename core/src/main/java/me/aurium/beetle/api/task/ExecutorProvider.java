package me.aurium.beetle.api.task;

import java.util.concurrent.Executor;

public interface ExecutorProvider {

    /**
     * Gets the platform specific async executor. All platforms have one, whether it is safe to
     * use or not depends on the api implementer
     *
     * TODO as much as i'd love to use that as an excuse i AM the api implementer for this
     * so bukkit based platforms will need to have some kind of warning until le pr gets merged
     *
     * @return async executor
     */
    Executor getAsyncExecutor();

}
