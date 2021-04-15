package me.aurium.beetle.api.task.futures;

import java.util.concurrent.Executor;

public interface FutureCore {

    Executor getDefaultExecutor();

}
