package me.aurium.beetle.core;

import me.aurium.beetle.core.logger.SimpleLogger;
import me.aurium.beetle.core.task.TaskRunner;

public interface BeetleFactory {

    Beetle build();

}
