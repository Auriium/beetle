package me.aurium.beetle.api.task;

/**
 * Something that can provide a runner (lol)
 *
 * eventually all of this stuff will be due for an update / rework to provide functionality like resyncing to main thread
 * with the SyncFuture, which would mean making everything adjusted to return a super class of SyncFuture, and having a
 * another implementation SynclesFuture with NotImplementedExceptions (gross) but until then, Tasker will have
 * to do :)
 */
public interface Tasker {

    TaskRunner getRunner();

    /**
     * WARNING: READ THIS:
     *
     * This isn't called getExecutors for a reason. You should only use these if you know what you are doing.
     * If you are on the bukkit platforms you should read pr: 4064
     *
     * @return the executorProvider
     */
    ExecutorProvider exposeExecutors();

}
