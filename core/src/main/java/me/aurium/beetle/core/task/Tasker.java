package me.aurium.beetle.core.task;

public interface Tasker {

    TaskQueue getQueue();
    TaskRunner getRunner();

    void launch();

}
