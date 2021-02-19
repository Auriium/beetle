package me.aurium.beetle.core;

import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.runner.TaskRunner;

public interface BeetleFactory {

    Beetle build();

    Beetle build(TaskRunner runner);
    Beetle build(SimpleLogger logger);
    Beetle build (TaskRunner runner, SimpleLogger logger);

}
