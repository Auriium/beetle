package me.aurium.beetle.api.task;

/**
 * Represents a tickable thing that can be launched that ticks it's taskqueue once launched
 */
public interface Tasker {

    TaskQueue getQueue();
    TaskRunner getRunner();

    void launch();

}
